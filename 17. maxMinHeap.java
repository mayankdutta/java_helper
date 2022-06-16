static long maximumEnjoyment(int k, int[] c, int[] t) {

    // Declaring 'n' as the total number of dishes.
    int n = c.length;

    // Declarng 'dishes' which will store the tastiness and cuisine of each dish.
    ArrayList<ArrayList<Integer>> dishes = new ArrayList<>();

    for (int i = 0; i < n; ++i) {
        dishes.add(new ArrayList<>(List.of(t[i], c[i])));
    }

    // Sorting the dishes in descending order of their tastiness.
    dishes.sort((o1, o2) -> {
        if (o1.equals(o2)) {
            return o2.get(1).compareTo(o1.get(1));
        }
        return o2.get(0).compareTo(o1.get(0));
    });


    long tot = 0, variety = 0;

    boolean[] used = new boolean[n + 1];
    Arrays.fill(used, false);

    // Declaring a maximum heap
    PriorityQueue<ArrayList<Integer>> unselected = new PriorityQueue<>((o1, o2) -> {
        if (o1.get(0).equals(o2.get(0))) {
            return o2.get(1).compareTo(o1.get(1));
        }
        return o2.get(0).compareTo(o1.get(0));
    });

    /* Declaring a minimum heap */
    PriorityQueue<ArrayList<Integer>> selected = new PriorityQueue<>((o1, o2) -> {
        if (o1.get(0).equals(o2.get(0))) {
            return o1.get(1).compareTo(o2.get(1));
        }
        return o1.get(0).compareTo(o2.get(0));
    });

    // Running a loop for iterating on the first 'k' dishes.
    for (int i = 0; i < k; ++i) {

        /* Pushing the current dish in 'selected' if another dish of the same cuisine is
        already selected; otherwise incrementing variety and marking its cuisine as present in 'used'. */
        if (used[dishes.get(i).get(1)]) {
            selected.add(dishes.get(i));
        } else {
            used[dishes.get(i).get(1)] = true;
            variety++;
        }

        // Adding the current dish's tastiness to the total tastiness.
        tot += (long) dishes.get(i).get(0);
    }

    // Running a loop on the remaining dishes and pushing them in 'unselected'.
    for (int i = k; i < n; ++i) {
        unselected.offer(dishes.get(i));
    }

    // Declaring 'ans' for storing the final answer with the value of the current answer.
    long ans = tot + (variety * variety);

    // Running a loop till there are no dishes to replace with or be replaced.
    while (!selected.isEmpty() && !unselected.isEmpty()) {

        // Declaring 'addition' as the dish on top of 'unselected'.
        ArrayList<Integer> addition = unselected.poll();

        /* Continuing to next iteration if another dish with the cuisine category
        of 'add' is already selected. */
        if (used[addition.get(1)]) {
            continue;
        }

        /* Adding tastiness of 'add' to the total tastiness, marking its cuisine as
        present in 'used', and incrementing variety. */
        tot += (long) addition.get(0);
        used[addition.get(1)] = true;
        variety++;

        // Declaring 'removal' as the dish on top of 'selected'.
        ArrayList<Integer> removal = selected.poll();

        // Subtracting tastiness of 'remove' from the toal tastiness.
        tot -= (long) removal.get(0);

        // Updating 'ans' with the current answer.
        ans = Math.max(ans, tot + (variety * variety));
    }

    // Returning the final answer stored in 'ans'.
    return ans;
}

