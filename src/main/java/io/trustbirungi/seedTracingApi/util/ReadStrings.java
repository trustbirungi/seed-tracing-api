package io.trustbirungi.seedTracingApi.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadStrings {
	public static void main(String[] args) throws IOException {
		//getDataRange();
		//groupRepeatTraineeData();
		groupTrainedOthersData();
	}

	/**
	 * Reads the data range to use for the spreadsheet before each fetch.
	 * @return dataRange - The data range to be used when fetching from the
	 * spreadsheet.
	 */
	private static void getDataRange() throws IOException {
		List<String> metaInstancesList = new ArrayList<>();
		List<TraineeRepeat> traineeRepeatList = new ArrayList<>();
		Path seedMultiPath = Paths.get("src/main/resources/static/seed_multi"
				+ ".txt");

		Path traineeRepeatPath = Paths.get("src/main/resources/static"
				+ "/trainee_repeat"
				+ ".txt");

		BufferedReader bufferedReader = null;

		try {
			bufferedReader = new BufferedReader(new FileReader(
					String.valueOf(seedMultiPath)));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line;

		while((line = bufferedReader.readLine()) != null) {
			metaInstancesList.add(line);
		}

		try {
			bufferedReader = new BufferedReader(new FileReader(
					String.valueOf(traineeRepeatPath)));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//String line;

		while((line = bufferedReader.readLine()) != null) {
			String[] splitHolder = line.split(",");

			TraineeRepeat traineeRepeat = new TraineeRepeat(
					splitHolder[1],
					splitHolder[2],
					splitHolder[3],
					splitHolder[4],
					splitHolder[5],
					splitHolder[6]
			);

			traineeRepeatList.add(traineeRepeat);
		}

		for(int i = 0; i < traineeRepeatList.size(); i++) {
			traineeRepeatList.get(i).parentUID = metaInstancesList.get(i);
		}

		String insertPrefix = "INSERT INTO `trainee_repeat` ("
				+ "`parent_uid`,`trainee_first_name`,`trainee_last_name`,"
				+ "`trainee_sex`,`trainee_training_date`,`trainee_district`) VALUES (";

		String insertPostfix = ");";

		for(TraineeRepeat traineeRepeat : traineeRepeatList) {
			System.out.println(
					insertPrefix +
							traineeRepeat.parentUID + ", " +
							traineeRepeat.firstName + ", " +
							traineeRepeat.lastName + ", " +
							traineeRepeat.sex + ", " +
							traineeRepeat.trainingDate + ", " +
							traineeRepeat.district +
					insertPostfix
			);
		}
	}


	/**
	 * Reads the data range to use for the spreadsheet before each fetch.
	 * @return dataRange - The data range to be used when fetching from the
	 * spreadsheet.
	 */
	private static void groupRepeatTraineeData() throws IOException {
		List<String> metaInstancesList = new ArrayList<>();
		List<GroupRepeatTrainee> groupRepeatTraineeList = new ArrayList<>();
		Path seedMultiPath = Paths.get("src/main/resources/static/seed_multi"
				+ ".txt");

		Path groupRepeatTraineePath = Paths.get("src/main/resources/static"
				+ "/group_trainee_repeat"
				+ ".txt");

		BufferedReader bufferedReader = null;

		try {
			bufferedReader = new BufferedReader(new FileReader(
					String.valueOf(seedMultiPath)));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line;

		while((line = bufferedReader.readLine()) != null) {
			metaInstancesList.add(line);
		}

		try {
			bufferedReader = new BufferedReader(new FileReader(
					String.valueOf(groupRepeatTraineePath)));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//String line;

		while((line = bufferedReader.readLine()) != null) {
			String[] splitHolder = line.split(",");

			GroupRepeatTrainee groupRepeatTrainee = new GroupRepeatTrainee(
					splitHolder[1],
					splitHolder[2],
					splitHolder[3],
					splitHolder[4]
			);

			groupRepeatTraineeList.add(groupRepeatTrainee);
		}

		for(int i = 0; i < groupRepeatTraineeList.size(); i++) {
			groupRepeatTraineeList.get(i).parentUID = metaInstancesList.get(i);
		}

		String insertPrefix = "INSERT INTO `seed_tracing_db`"
				+ ".`group_trainee_repeat` (`parent_uid`,`group_trainee_name`,`group_trainee_training_date`,`group_trainee_district`) VALUES (";

		String insertPostfix = ");";

		for(GroupRepeatTrainee groupRepeatTrainee : groupRepeatTraineeList) {
			System.out.println(
					insertPrefix +
							groupRepeatTrainee.parentUID + ", " +
							groupRepeatTrainee.groupTraineeName + ", " +
							groupRepeatTrainee.groupTrainingDate + ", " +
							groupRepeatTrainee.groupDistrict +
							insertPostfix
			);
		}
	}

	/**
	 * Reads the data range to use for the spreadsheet before each fetch.
	 * @return dataRange - The data range to be used when fetching from the
	 * spreadsheet.
	 */
	private static void groupTrainedOthersData() throws IOException {
		List<String> metaInstancesList = new ArrayList<>();
		List<GroupTrainedOthersRepeat> groupTrainedOthersRepeatList = new ArrayList<>();
		Path seedMultiPath = Paths.get("src/main/resources/static/seed_multi"
				+ ".txt");

		Path groupRepeatTraineePath = Paths.get("src/main/resources/static"
				+ "/group_trained_others_repeat"
				+ ".txt");

		BufferedReader bufferedReader = null;

		try {
			bufferedReader = new BufferedReader(new FileReader(
					String.valueOf(seedMultiPath)));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line;

		while((line = bufferedReader.readLine()) != null) {
			metaInstancesList.add(line);
		}

		try {
			bufferedReader = new BufferedReader(new FileReader(
					String.valueOf(groupRepeatTraineePath)));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//String line;

		while((line = bufferedReader.readLine()) != null) {
			String[] splitHolder = line.split(",");

			GroupTrainedOthersRepeat groupTrainedOthersRepeat = new GroupTrainedOthersRepeat(
					splitHolder[1],
					splitHolder[2]
			);

			groupTrainedOthersRepeatList.add(groupTrainedOthersRepeat);
		}

		for(int i = 0; i < groupTrainedOthersRepeatList.size(); i++) {
			groupTrainedOthersRepeatList.get(i).parentUID = metaInstancesList.get(i);
		}

		String insertPrefix = "INSERT INTO `seed_tracing_db`"
				+ ".`group_trained_others_repeat` (`parent_uid`,`trained_group_that_has_trained_others`) VALUES (";

		String insertPostfix = ");";

		for(GroupTrainedOthersRepeat groupTrainedOthersRepeat : groupTrainedOthersRepeatList) {
			System.out.println(
					insertPrefix +
							groupTrainedOthersRepeat.parentUID + ", " +
							groupTrainedOthersRepeat.trainedGroup +
							insertPostfix
			);
		}
	}

}

class TraineeRepeat {
	String parentUID, firstName, lastName, sex, trainingDate, district;

	public TraineeRepeat(String parentUID, String firstName, String lastName,
	                     String sex, String trainingDate, String district) {
		this.parentUID = parentUID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.trainingDate = trainingDate;
		this.district = district;
	}
}

class GroupRepeatTrainee {
	String parentUID, groupTraineeName, groupTrainingDate, groupDistrict;

	public GroupRepeatTrainee(String parentUID, String groupTraineeName,
	                          String groupTrainingDate, String groupDistrict) {
		this.parentUID = parentUID;
		this.groupTraineeName = groupTraineeName;
		this.groupTrainingDate = groupTrainingDate;
		this.groupDistrict = groupDistrict;
	}
}

class GroupTrainedOthersRepeat {
	String parentUID, trainedGroup;

	public GroupTrainedOthersRepeat(String parentUID, String trainedGroup) {
		this.parentUID = parentUID;
		this.trainedGroup = trainedGroup;
	}
}
