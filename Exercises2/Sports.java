
public class Sports {

	public static void main(String[] args) {
		
		Sport[] sportArray = new Sport[7];
		sportArray[0] = new BallSport("Football", "Net, Ball", "Pitch", 2, 11, 90);
		sportArray[1] = new BallSport("Rugby", "Goal, Ball", "Pitch", 2, 15, 80);
		sportArray[2] = new MotorSport("Formula 1", "Car", "Track", 11, 2, 70);
		sportArray[3] = new MotorSport("Moto GP", "Motorcycle", "Track", 13, 3, 80);
		sportArray[4] = new RacketSport("Tennis", "Racket", "Court", 40);
		sportArray[5] = new RacketSport("Badminton", "Racket", "Court", 30);
		sportArray[6] = new Golf("Golf", "Golf Clubs", "Course");
		
		for (int i = 0; i < sportArray.length; i++) {
			String SportName = sportArray[i].getName();
			String Equipment = sportArray[i].getEquipment();
			String Location = sportArray[i].getLocation();
			System.out.println(SportName);
			System.out.println(Equipment);
			System.out.println(Location);
			if (sportArray[i] instanceof TeamSport) {
				String NumberOfTeams = sportArray[i].getNumberOfTeams();
				System.out.println(NumberOfTeams);
			}
			System.out.println("\n");
		}

	}

}
