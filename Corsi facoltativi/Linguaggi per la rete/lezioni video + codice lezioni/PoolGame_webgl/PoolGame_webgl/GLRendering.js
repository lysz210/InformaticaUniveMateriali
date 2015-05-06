
var engine_glcontext;

var GLRendering_initialize = function(Width, Height, drawables ) {

    var context = {};
    context.w = Width||1000;
    context.h = Height||570;
    var ratio = context.w/context.h;

    context.scene = new THREE.Scene();
    context.camera = new THREE.PerspectiveCamera( 75, ratio, 10, 10000 );

    context.renderer = new THREE.WebGLRenderer();
    context.renderer.setSize( context.w, context.h );

    var domElem = context.renderer.domElement;
    domElem.id = 'svg';
    document.body.appendChild(domElem);

    var ambient_light = new THREE.AmbientLight( 0x202020 ); // soft white light
    context.scene.add( ambient_light );
    var directionalLight = new THREE.DirectionalLight( 0xffffff, 0.8 );
    directionalLight.position.set( 0, 0, 1 );
    context.scene.add( directionalLight );


    // Create Pool Table mesh
    var geometry = new THREE.PlaneGeometry( context.w, context.h );

    var material = new THREE.MeshBasicMaterial( {map:THREE.ImageUtils.loadTexture('textures/pool_table.png'), 
                                               side: THREE.DoubleSide} );
    var tablemesh = new THREE.Mesh( geometry, material );
    tablemesh.name = 'table';
    context.scene.add( tablemesh );


    // Create Balls
    var create_ball = function( index, radius ) {
        var geometry = new THREE.SphereGeometry( radius, 20, 20 );
        var material = new THREE.MeshLambertMaterial( {map:THREE.ImageUtils.loadTexture('textures/ball_'+index+'.jpg')} );
        var ball = new THREE.Mesh( geometry, material );
        ball.name = 'ball'+index;
        ball.matrixAutoUpdate=false;
        return ball;
    }

    var ball_group = new THREE.Group();
    drawables.forEach( function(obj) {
        if( obj instanceof Ball ) {
            var ball_mesh = create_ball( obj.number, obj.radius );
            ball_mesh.position.x = obj.position.x;
            ball_mesh.position.y = obj.position.y;
            ball_mesh.position.z = obj.radius;
            ball_group.add( ball_mesh );
        }
    });

    ball_group.position.x=-context.w/2;
    ball_group.position.y=-context.h/2;
    tablemesh.add( ball_group );

    var poles_group = new THREE.Group();
    poles_group.name = 'poles';
    poles_group.position.x=-context.w/2;
    poles_group.position.y=-context.h/2;
    tablemesh.add( poles_group );

    // Camera setup
    context.camera.position.z = 500;
    context.camera.position.y = -100;
    context.camera.lookAt( new THREE.Vector3(0,0,0) );
    
    return context;
}

var renderAllGL = function( ctx, drawables ) {

    // Update the scene
    drawables.forEach( function(obj) {
        if( obj instanceof Ball ) {
            var ball_mesh = ctx.scene.getObjectByName( 'ball'+obj.number, true );
            if( ball_mesh ) {

                var ball_tr = new THREE.Matrix4().makeTranslation( obj.position.x, ctx.h-obj.position.y, obj.radius );

                // Rotation axis must be orthogonal to current speed so we swap x-y
                var rot_axis = new THREE.Vector3( obj.speed.y, obj.speed.x, 0 ).normalize();

                var ball_r = new THREE.Matrix4().makeRotationAxis( rot_axis, obj.speed.len() );
                var curr_rot = new THREE.Matrix4().extractRotation( ball_mesh.matrix );

                // Apply in order current_rotation -> ball_r -> ball_translation
                ball_r.multiply(curr_rot);
                ball_mesh.matrix = ball_tr.multiply(ball_r);
            }
        }
        if( obj instanceof Pole ) {
            var ball0 = ctx.scene.getObjectByName( 'ball0', true );

            var ball0_pos = new THREE.Vector3( ball0.matrix.elements[12], 
                                               ball0.matrix.elements[13], 
                                               ball0.matrix.elements[14] );

            if( !obj.polemesh ) {

                var material = new THREE.LineBasicMaterial({
                    color: 0xffff00
                });
                var geometry = new THREE.Geometry();
                geometry.vertices.push( new THREE.Vector3( 0,0,1 ), new THREE.Vector3( 1,0,1 ));
                obj.polemesh = new THREE.Line( geometry, material );
                ctx.scene.getObjectByName('poles').add( obj.polemesh );
            }

            var polesize = obj.a.distance(obj.b);
            var poleangle = Math.atan2( obj.a.y - obj.b.y, obj.b.x - obj.a.x );
            if( polesize>1 ) {
                obj.polemesh.scale.x = polesize;
                obj.polemesh.rotation.z = poleangle;
                obj.polemesh.position.x = ball0_pos.x;
                obj.polemesh.position.y = ball0_pos.y;
            } else {
                obj.polemesh.position.x = ctx.w*10; // put the pole outside the visible viewport to let it disappear
            }
        }
    });

    // Render
    ctx.renderer.render( ctx.scene, ctx.camera );
}


/*
window.onload = function() {
    var ctx = GLRendering_initialize( 1000, 570 );

    var render=function() {
        ctx.renderer.render( ctx.scene, ctx.camera );
        requestAnimationFrame( render );
    }
    render();
};
*/
