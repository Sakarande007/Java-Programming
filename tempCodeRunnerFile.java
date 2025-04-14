public class tempCodeRunnerFile {
    public static int findNoOfSuggestions(String[] friendshipRelations) {
        int noOfUsers = friendshipRelations.length;
        int count = 0;

        for (int u = 0; u < noOfUsers; u++) {
            for (int v = u + 1; v < noOfUsers; v++) {
                boolean mutualFriendExists = false;
                for (int w = 0; w < noOfUsers; w++) {
                    if (friendshipRelations[u].charAt(w) == '1' && friendshipRelations[v].charAt(w) == '1') {
                        mutualFriendExists = true;
                        break;
                    }
                }
                if (mutualFriendExists) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String[] friendshipRelations = { "0111", "1000", "1000", "10001" };
        int result = findNoOfSuggestions(friendshipRelations);
        System.out.println(result); // Print the number of friend suggestions
    }
}
