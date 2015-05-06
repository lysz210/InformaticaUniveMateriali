
var baseVector = Object.defineProperties({},
    {
        x: { value:0, writable: true, enumerable: false, configurable: true },
        y: { value:0, writable: true, enumerable: false, configurable: true },
        
        set: { writable: false, enumerable: false, configurable: true, value: 
           function(point)
           {
               this.x=point.x;
               this.y=point.y;
               return this;
           }
        },
        
        add: { writable: false, enumerable: false, configurable: true, value: 
           function(displacement)
           {
               this.x+=displacement.x;
               this.y+=displacement.y;
               return this;
           }
        },
        
        sub: { writable: false, enumerable: false, configurable: true, value: 
           function(displacement)
           {
               this.x-=displacement.x;
               this.y-=displacement.y;
               return this;
           }
        },
        
        mul: { writable: false, enumerable: false, configurable: true, value: 
           function(scale)
           {
               this.x*=scale;
               this.y*=scale;
               return this;
           }
        },
        
        dot: { writable: false, enumerable: false, configurable: true, value: 
           function(v)
           {
               return this.x*v.x+this.y*v.y;
           }
        },
        
        clone: { writable: false, enumerable: false, configurable: true, value: 
           function()
           {
               return new Vector(this.x,this.y);
           }
        },                
        
        normalize: { writable: false, enumerable: false, configurable: true, value: 
           function()
           {
               var scale = this.len();
               this.x/=scale;
               this.y/=scale;
               return this;
           }
        },
        
        distance: { writable: false, enumerable: false, configurable: true, value: 
           function(v)
           {
               return Math.sqrt(this.squaredDistance(v));
           }
        },                
        
        squaredDistance: { writable: false, enumerable: false, configurable: true, value: 
           function(v)
           {
               return (this.x-v.x)*(this.x-v.x)+(this.y-v.y)*(this.y-v.y);
           }
        },                
        
        len: { writable: false, enumerable: false, configurable: true, value: 
           function()
           {
               return Math.sqrt(this.squaredLen());
           }
        },                
        
        squaredLen: { writable: false, enumerable: false, configurable: true, value: 
           function(v)
           {
               return this.x*this.x+this.y*this.y;
           }
        },                
        
        isNull: { writable: false, enumerable: false, configurable: true, value: 
           function()
           {
               return (this.x==0)&&(this.y==0);
           }
        },                
        
        toString: { writable: false, enumerable: false, configurable: true, value: 
           function()
           {
               return "Vector(x: "+this.x+" y: "+this.y+")";
           }
        }
    });    

function Vector(x, y)
{
    this.x = x;
    this.y = y;
}
Vector.prototype = baseVector;

var baseSegment = Object.defineProperties({},
    {
        a: { value:new Vector(0,0), writable: true, enumerable: false, configurable: true },
        b: { value:new Vector(0,0), writable: true, enumerable: false, configurable: true },      
        
        len: { writable: false, enumerable: false, configurable: true, value: 
           function()
           {
               return this.a.distance(this.b);
           }
        },
        
        direction: { writable: false, enumerable: false, configurable: true, value: 
           function()
           {
               var l = this.a.distance(this.b);
               return new Vector((this.b.x-this.a.x)/l,(this.b.y-this.a.y)/l);
           }
        },                

        squaredDistanceFromPoint: { writable: false, enumerable: false, configurable: true, value: 
           function(p)
           {
               var l2 = this.a.squaredDistance(this.b);
               var t = ((p.x - this.a.x) * (this.b.x - this.a.x) + (p.y - this.a.y) * (this.b.y - this.a.y)) / l2;
               if (t < 0) return p.squaredDistance(this.a);
               if (t > 1) return p.squaredDistance(this.b);;
               return p.squaredDistance(new Vector( this.a.x + t * (this.b.x - this.a.x), this.a.y + t * (this.b.y - this.a.y) ));
           }
        },
        
        distanceFromPoint: { writable: false, enumerable: false, configurable: true, value: 
           function(p)
           {
               return Math.sqrt(this.squaredDistanceFromPoint(p));
           }
        },
        
        orthogonalVectorFromPoint: { writable: false, enumerable: false, configurable: true, value: 
           function(p)
           {
               var direction = this.direction();
               var projection = p.clone().sub(this.a).dot(direction);
               var orthogonal = this.a.clone().add(direction.mul(projection)).sub(p);
               return orthogonal;
           }
        }
        
    });    


function Segment(a, b)
{
    this.a = a;
    this.b = b;
}
Segment.prototype = baseSegment;


function Ball(position, radius, speed, color, mass)
{
    Object.defineProperties(this,
    {
        position: { value: position, writable: true, enumerable: false, configurable: true },
        radius: { value: radius, writable: true, enumerable: false, configurable: true },
        speed: { value: speed?speed:new Vector(0,0), writable: true, enumerable: false, configurable: true },
        color: { value: color?color:"#ff0000", writable: true, enumerable: false, configurable: true },
        mass: { value: mass?mass:1.0, writable: true, enumerable: false, configurable: true },
        
        move: { writable: false, enumerable: false, configurable: true, value: 
           function(displacement)
           {
               this.position.add(displacement);
           }
        },
        
        place: { writable: false, enumerable: false, configurable: true, value: 
           function(newposition)
           {
               this.position.set(newposition);
           }
        },
        
        update: { writable: true, enumerable: false, configurable: true, value: 
           function(timestep)
           {
               this.move(this.speed.clone().mul(timestep));
           }
        },
        
        toString: {  writable: false, enumerable: false, configurable: true, value: 
           function()
           {
               return "position: "+this.position+", radius: "+this.radius+", speed: "+this.speed;
           }
        },
        
        touchesBall: {  writable: false, enumerable: false, configurable: true, value: 
           function(otherBall)
           {
              return this.position.distance(otherBall.position) <= this.radius+otherBall.radius;
           }
        },
        
        touchesSegment: {  writable: false, enumerable: false, configurable: true, value: 
           function(segment)
           {
               return segment.distanceFromPoint(this.position)<=radius &&
                      segment.orthogonalVectorFromPoint(this.position).dot(this.speed)>0.0;
           }
        },
        
        bounceWithBall: {  writable: false, enumerable: false, configurable: true, value: 
           function(ball)
           {
             var delta  = this.position.clone().sub(ball.position).normalize();
	     var impulse = 2 * this.speed.clone().sub(ball.speed).dot(delta) / ( (1/this.mass) + (1/ball.mass) );
             if(impulse < 0)
             {
                this.speed.sub( delta.clone().mul( impulse / this.mass ) );
                ball.speed.add( delta.clone().mul( impulse / ball.mass ) );
             }               
           }
        },
        
        bounceWithSegment: {  writable: false, enumerable: false, configurable: true, value: 
           function(l)
           {
              var n = l.direction();
              this.speed = new Vector(this.speed.dot(new Vector(n.x*n.x-n.y*n.y,2*n.x*n.y)),
	                              this.speed.dot(new Vector(2*n.x*n.y,n.y*n.y-n.x*n.x)));
           }
        }
        
    });
}


