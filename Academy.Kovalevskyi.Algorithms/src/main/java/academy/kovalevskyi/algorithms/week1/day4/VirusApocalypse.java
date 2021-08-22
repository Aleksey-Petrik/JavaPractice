package academy.kovalevskyi.algorithms.week1.day4;

public class VirusApocalypse {

  public static int countDays(Integer[][] startingUniverse) {
    int countDay = 0;
    int countLivePeople = getPopulationPeople(startingUniverse);

    while (countLivePeople != 0) {
      int countInfectionPeople = 0;
      for (int y = 0; y < startingUniverse.length; y++) {
        for (int x = 0; x < startingUniverse[y].length; x++) {
          if (startingUniverse[y][x] < 0 && countDay + 1 > Math.abs(startingUniverse[y][x])) {
            startingUniverse[y][x] = 1;
          }
          if (startingUniverse[y][x] == 1) {
            countInfectionPeople += getCountInfectionPeople(startingUniverse, countDay, x, y);
          }
        }
      }
      countLivePeople -= countInfectionPeople;
      if (countInfectionPeople == 0 && countLivePeople > 0) {
        return -1;
      }
      countDay++;
    }
    return countDay;
  }

  private static int getPopulationPeople(Integer[][] startingUniverse) {
    int countLivePeople = 0;
    for (Integer[] integers : startingUniverse) {
      for (Integer integer : integers) {
        if (integer == 0) {
          countLivePeople++;
        }
      }
    }
    return countLivePeople;
  }

  private static int getInjectionState(int day) {
    return -(day + 1);
  }

  private static int getCountInfectionPeople(Integer[][] startingUniverse, int day, int x, int y) {
    int countInfection = 0;
    if (x + 1 < startingUniverse[y].length && startingUniverse[y][x + 1] == 0) {
      startingUniverse[y][x + 1] = getInjectionState(day);
      countInfection++;
    }
    if (y != 0 && startingUniverse[y - 1][x] == 0) {
      startingUniverse[y - 1][x] = getInjectionState(day);
      countInfection++;
    }
    if (y + 1 < startingUniverse.length && startingUniverse[y + 1][x] == 0) {
      startingUniverse[y + 1][x] = getInjectionState(day);
      countInfection++;
    }
    if (x != 0 && startingUniverse[y][x - 1] == 0) {
      startingUniverse[y][x - 1] = getInjectionState(day);
      countInfection++;
    }
    return countInfection;
  }

}
