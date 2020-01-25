import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInput {
  private static final String DELIMITER = ",";
  private List<User> users = new ArrayList<>();
  private List<ResultOption> resultOptions = new ArrayList<>();
  private int height;

  public UserInput(){}

  public UserInput(List<User> users, int height) {
    this.users = users;
    this.height = height;
  }

  public UserInput getUserInput() {
    getUserNames();
    getLadderHeight();
    getResultOptions();
    return this;
  }

  private void getUserNames() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    Scanner scan = new Scanner(System.in);
    String nameInput = scan.nextLine();
    String[] nameArr = nameInput.split(DELIMITER);
    users.addAll(Arrays.stream(nameArr).map(User::of).collect(Collectors.toList()));
  }

  private void getLadderHeight() {
    System.out.println("사다리 높이는?");
    Scanner scan = new Scanner(System.in);
    height = scan.nextInt();
  }

  private void getResultOptions() {
    System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    Scanner scan = new Scanner(System.in);
    String nameInput = scan.nextLine();
    String[] nameArr = nameInput.split(DELIMITER);
    resultOptions.addAll(Arrays.stream(nameArr).map(ResultOption::of).collect(Collectors.toList()));
  }

  public List<User> getUsers() {
    return users;
  }

  public int getHeight() {
    return height;
  }

  public void printUsers() {
    for (User user: users) {
      System.out.print("  " + user + "\t  ");
    }
    System.out.println();
  }

  public void printResultOptions() {
    for (ResultOption result : resultOptions) {
      System.out.print("  " + result + "\t  ");
    }
    System.out.println();
  }
}
