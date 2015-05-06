window.onload = function() {

    var scene = new THREE.Scene();

    var camera = new THREE.PerspectiveCamera( 75, window.innerWidth/window.innerHeight, 0.1, 1000);

    camera.position.z = 3;
    
    var renderer = new THREE.WebGLRenderer();
    renderer.setSize( window.innerWidth, window.innerHeight );
    document.body.appendChild( renderer.domElement );


    var geometry = new THREE.BoxGeometry( 1,1,1 );
    var material = new THREE.MeshLambertMaterial( { 
        map: THREE.ImageUtils.loadTexture('crate1.png') 
    } );
    var cube1 = new THREE.Mesh( geometry, material );
    cube1.matrixAutoUpdate = false;
    scene.add(cube1);


    material = new THREE.MeshLambertMaterial( { 
        map: THREE.ImageUtils.loadTexture('crate2.png') 
    } );
    var cube2 = new THREE.Mesh( geometry, material );
    cube2.matrixAutoUpdate = false;
    //cube1.add(cube2);
    scene.add(cube2);
    

    var directionalLight = new THREE.DirectionalLight( 0xffffff, 0.5 );
    directionalLight.position.set( 0.5, 0, 1 ).normalize();
    scene.add( directionalLight );


    var render = function() {

        var now = new Date();
        var dt = now-(render.time||now);
        render.time =now;

        var cube2_tras = new THREE.Matrix4().makeTranslation(2,0,0);
        var cube2_rot = new THREE.Matrix4().makeRotationY( 0.001*render.time );
        cube2.matrix = cube2_tras.multiply( cube2_rot );
        //cube2.matrix = cube2_rot.multiply( cube2_tras );

        var cube1_tras = new THREE.Matrix4().makeTranslation(Math.sin(render.time*0.01),0,0);
        cube1.matrix = cube1_tras;
        
        renderer.render( scene, camera );

        requestAnimationFrame( render );
    }

    render();
}
