class BufferApp
{
    public static void main(String[] args) 
    {
        Buffer b = new Buffer(4); // _::_::_::_
	System.out.println(b.toString());
        b.set(1,'a');	          // _::a::_::_
	System.out.println(b.toString());
        b.set(1,'b');             // _::b::_::_
	System.out.println(b.toString());
        b.undo();                 // _::a::_::_
	System.out.println(b.toString());
        b.set(3,'c');             // _::a::_::c
	System.out.println(b.toString());
        b.undo();   	          // _::a::_::_
	System.out.println(b.toString());
        b.undo();   	          // _::_::_::_
	System.out.println(b.toString());
        b.undo();   	          // _::_::_::_
	System.out.println(b.toString());
    }
}
