class QueueApp 
{
    public static void main(String[] args)
    {
	Queue q = new Queue(4);
	q.enqueue(1);
	System.out.println(q.toString());
	q.enqueue(2);
	System.out.println(q.toString());
	q.enqueue(3);
	System.out.println(q.toString());
	q.enqueue(4);
	System.out.println(q.toString());
	q.dequeue();
	System.out.println(q.toString());
	q.dequeue();
	System.out.println(q.toString());
	q.enqueue(5);
	System.out.println(q.toString());
	q.enqueue(6);
	System.out.println(q.toString());
	q.enqueue(7);
	System.out.println(q.toString());
	q.enqueue(8);
	System.out.println(q.toString());
	q.enqueue(9);
	System.out.println(q.toString());
	q.enqueue(10);
	System.out.println(q.toString());
	q.enqueue(11);
	System.out.println(q.toString());
    }
}