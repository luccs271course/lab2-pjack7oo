package edu.luc.cs.cs271.lab2;

import java.util.List;
import java.util.Optional;

public class Search {

  /** Looks for the position of the named team in an array. */
  public static Optional<Integer> findTeamPosition(final Team[] arr, final String key) {
    // Gets the array size
    final int size = arr.length;
    // Runs through a for loop to check
    for (int i = 0; i < size; i++) {
      // Gets the current item at index and compare name to key
      if (arr[i].getName().equals(key)) {
        // Return the index of where the item with key is located
        return Optional.of(i);
      }
    }
    // If it does not exist in the array then return an index of -1
    return Optional.empty();
  }

  /** Looks for the position of the named team in a list. */
  public static Optional<Integer> findTeamPosition(final List<Team> list, final String key) {
    // done complete this method
    final int size = list.size();
    for (int i = 0; i < size; i++) {
      if (list.get(i).getName().equals(key)) {
        return Optional.of(i);
      }
    }
    return Optional.empty();
  }
  
  /** 
   * Looks for the position of the poorest team that has at least 
   * the specified funding level.
   * @pre arr is sorted
   * @post arr[result].funding >= minFunding && for all 0 <= i < result : arr[i].funding < minFunding
   */
  public static Optional<Integer> findTeamMinFunding(final Team[] arr, final int minFunding) {
    //done  complete this method
      final int size = arr.length;
      int temp = 0;
      boolean min = true;
      for (int i = 0; i <size; i++) {
          if (arr[i].getFunding() == minFunding || arr[i].getFunding() > minFunding) {
              return Optional.of(i);
          }
          else if (arr[i].getFunding() < minFunding) {
              min = false;
          }
        }
      if (min == false) {
          System.out.println("No team has at least " + minFunding + ".");
      }
    return Optional.empty();
  }
  
  /** 
   * Looks for the position of the poorest team that has at least 
   * the specified funding level. 
   * Uses binary search: Initially search the entire array, 
   * then repeatedly eliminate the wrong half of the array until 
   * zero or one items are left.
   * @pre arr is sorted
   * @post arr[result].funding >= minFunding && for all 0 <= i < result : arr[i].funding < minFunding
   */
  public static Optional<Integer> findTeamMinFundingFast(final Team[] arr, final int minFunding) {
    // done complete this method
    // Gets the array size
    final int size = arr.length;
    // Initially search the entire array
    int low = 0;
    int high = size - 1;
    int mid = (low +high)/2;
    if(arr.length == 0) {

    }
    while(low <high) {
        mid = (low+high)/2;

        if (low == mid && minFunding > arr[low].getFunding() && minFunding <= arr[high].getFunding()) {
            return Optional.of(low+1);
        }
        if (minFunding < arr[mid].getFunding()) {
            high = mid;
        }
        if (minFunding > arr[mid].getFunding()) {
            low = mid;
        }
        if (minFunding == arr[mid].getFunding()) {
            return Optional.of(mid);
        }
        if (minFunding > arr[high].getFunding()) {
            break;
        }


    }
    //if () {
    // Keep going as long as there is more than one item to be checked
    // Eliminate the wrong half of the array
    // Return current item only if it meets the condition!
   if (low <= high && arr[low].getFunding() >= minFunding) {
     return Optional.of(low);
   }
   if (low <= high && arr[high].getFunding() <minFunding) {
        System.out.println("No team has at least " + minFunding);
        return Optional.empty();
   }
      else {
      return Optional.empty();
   }

  }

}
