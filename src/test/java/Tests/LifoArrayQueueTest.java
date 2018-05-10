package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import queue.LifoArrayQueue;
import queue.Queue;
import queue.QueueEmptyException;

public class LifoArrayQueueTest {


    @Rule
    public ExpectedException exception = ExpectedException.none();

    private Queue<Integer> indices = new LifoArrayQueue<>();

    @Before
    public void setup() {
        indices = new LifoArrayQueue<>();
    }

    @Test
    public void indices_front_equals_endices_dequeue() {
        indices.enqueue(1);
        Assert.assertTrue(indices.front().equals(indices.dequeue()));
    }

    @Test
    public void indices_dequeue_equals_indices_front() {
        indices.enqueue(2);
        indices.enqueue(3);
        Assert.assertFalse(indices.dequeue().equals(indices.front()));
    }

    @Test
    public void empty_queue_dequeue_throws_QueueEmptyException() {
        exception.expectMessage("Queue is empty");
        exception.expect(QueueEmptyException.class);
        indices.dequeue();
    }

    @Test
    public void test_toString_returns_expected_format() {

        for(int i = 0; i < 5; ++i) {
            indices.enqueue(i+1);
        }

        Assert.assertEquals("[1, 2, 3, 4, 5]", indices.toString());

    }
}
