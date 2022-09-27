import java.util.Arrays;

public class Heap {

    class minHeap{
        private int capacity = 10;
        private int size = 0;

        int[] items = new int[capacity];

        private int getLeftChildIndex(int parentIndex){
            return 2 * parentIndex + 1;
        }
        private int getRightChildIndex(int parentIndex){
            return 2 * parentIndex + 2;
        }
        private int getParentIndex(int childIndex){
            return (childIndex - 1) / 2;
        }


        private boolean hasLeftChild(int index){
            return getLeftChildIndex(index) < size;
        }
        private boolean hasRightChild(int index){
            return getRightChildIndex(index) > size;
        }
        private boolean hasParent(int index){
            return getParentIndex(index) >= 0;
        }


        private int leftChild(int index){
            return items[getLeftChildIndex(index)];
        }
        private int rightChild(int index){
            return items[getRightChildIndex(index)];
        }
        private int parent(int index){
            return items[getParentIndex(index)];
        }


        private void swap(int current, int replacement){
            int temp = items[current];
            items[current] = items[replacement];
            items[replacement] = current;
        }

        private void ensureExtraCapacity(){
            if(size == capacity){
                items = Arrays.copyOf(items, capacity*2);
                capacity *= 2;
            }
        }

        // remove an item
        public int poll(){
            if(size == 0) throw new IllegalStateException();
            int item = items[0];
            items[0] = items[size - 1];
            size--;
            heapifyDown();
            return item;
        }

        // add an item to the heap
        public void add(int item){
            ensureExtraCapacity();
            items[size] = item;
            size++;
            heapifyUp();
        }

        // method to move the topmost element in the heap to it's right position
        public void heapifyDown(){
            int index = 0;

            while(hasLeftChild(index)){
                int smallerChildIndex = getLeftChildIndex(index);

                if(hasLeftChild(index) && rightChild(index) < leftChild(index)){
                    smallerChildIndex = getRightChildIndex(index);
                }

                if(items[index] < items[smallerChildIndex])
                    break;
                else
                    swap(index, smallerChildIndex);

                index = smallerChildIndex;
            }
        }

        public void heapifyUp(){
            int index = size-1;

            while(hasParent(index) && parent(index) > items[index]){
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }
    }

    class maxHeap{

    }

}
