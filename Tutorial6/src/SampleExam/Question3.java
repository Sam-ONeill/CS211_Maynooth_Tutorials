package SampleExam;
import java.util.Arrays;

public class Question3 {

        public static void main(String[] args) {

        }

        public static int[] createHashTable(int[] keys) {
            int[] hashTable = new int[11];
            Arrays.fill(hashTable, -1); // Initialize all entries with -1

            for (int key : keys) {
                int index = hashFunction(key);
                int probeCount = 0;

                while (hashTable[index] != -1) {
                    index = (index + 1) % 11; // Linear probing
                    probeCount++;

                    if (probeCount == 11) {
                        // Hash table is full
                        System.out.println("Hash table is full. Unable to insert key: " + key);
                        return hashTable;
                    }
                }

                hashTable[index] = key;
            }

            return hashTable;
        }

        public static int hashFunction(int key) {
            return (3 * key + 5) % 11;
        }
}


