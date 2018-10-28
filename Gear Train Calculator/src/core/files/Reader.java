package core.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import core.math.Vector2f;
import core.math.Vector3f;

public class Reader {

	ArrayList<Specifications> specs;

	public Reader() {
		specs = new ArrayList<Specifications>();
	}

	public static void readConstraints(String path) {
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(path));

			String line;
			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split("=| |\t");
				tokens = removeEmptyStrings(tokens);

				if (tokens.length == 0 || tokens[0].startsWith("#"))
					continue;

				if (tokens[0].equals("z_axis_range")) {
					Constants.getConstants().setZ_axis_range(Integer.valueOf(tokens[1]));
				}
				if (tokens[0].equals("train_limit")) {
					Constants.getConstants().setMax_trains(Integer.valueOf(tokens[1]));
				}
				if (tokens[0].equals("gear_limit")) {
					Constants.getConstants().setMax_gears(Integer.valueOf(tokens[1]));
				}
				if (tokens[0].equals("print_speed")) {
					Constants.getConstants().setPrint_speed(Integer.valueOf(tokens[1]));
				}
				if (tokens[0].equals("print_time_limit")) {
					Constants.getConstants().setMax_print_time(Integer.valueOf(tokens[1]));
				}
				if (tokens[0].equals("sys_data_lims")) {
					ArrayList<String> data = new ArrayList<String>();
					while (!(line = reader.readLine()).equals("}")) {
						data.add(line);
					}
					processData(data);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void readSpecifications(String... files) {
		for (String file : files)
			createSpecification(file);
		
	}

	private void createSpecification(String file) {
		BufferedReader reader = null;
		int specsIndex = 0;

		try {
			reader = new BufferedReader(new FileReader(file));

			String line;
			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split("=| |\t|,");
				tokens = removeEmptyStrings(tokens);

				if (tokens.length == 0 || tokens[0].startsWith("#"))
					continue;

				if (tokens[0].equals("design")) {
					specs.add(new Specifications(tokens[1]));
				}
				if (tokens[0].equals("chassis-size")) {
					specs.get(specsIndex).setChassis_size(new Vector2f(Float.valueOf(tokens[1]), Float.valueOf(tokens[2])));
				}
				if (tokens[0].equals("landmark1_location")) {
					specs.get(specsIndex).setLandmark1(new Vector3f(Float.valueOf(tokens[1]), Float.valueOf(tokens[2]), 0));
				}
				if (tokens[0].equals("landmark1_direction")) {
					if(tokens[1].equals("CCW"))
						specs.get(specsIndex).setDir1(Constants.Direction.CCW);
					else
						specs.get(specsIndex).setDir1(Constants.Direction.CW);
				}
				if (tokens[0].equals("landmark1_rotation")) {
					specs.get(specsIndex).setSpeed1(Float.valueOf(tokens[1]));
				}
				if (tokens[0].equals("landmark2_location")) {
					specs.get(specsIndex).setLandmark2(new Vector3f(Float.valueOf(tokens[1]), Float.valueOf(tokens[2]), 0));
				}
				if (tokens[0].equals("landmark2_direction")) {
					if(tokens[1].equals("CW"))
						specs.get(specsIndex).setDir2(Constants.Direction.CW);
					else
						specs.get(specsIndex).setDir2(Constants.Direction.CCW);
				}
				if (tokens[0].equals("landmark2_rotation")) {
					specs.get(specsIndex).setSpeed2(Float.valueOf(tokens[1]));

				}
				if (tokens[0].equals("landmark3_location")) {
					specs.get(specsIndex).setLandmark3(new Vector3f(Float.valueOf(tokens[1]), Float.valueOf(tokens[2]), 0));
				}
				if (tokens[0].equals("landmark3_direction")) {
					if(tokens[1].equals("CW"))
						specs.get(specsIndex).setDir3(Constants.Direction.CW);
					else
						specs.get(specsIndex).setDir3(Constants.Direction.CCW);
				}
				if (tokens[0].equals("landmark3_rotation")) {
					specs.get(specsIndex).setSpeed3(Float.valueOf(tokens[1]));

				}
				if (tokens[0].equals("landmark3_offset")) {
					specs.get(specsIndex).getLandmark3().setZ(-Integer.valueOf(tokens[1]));
				}
				if (tokens[0].equals("functional_diameter")) {
					specs.get(specsIndex).setWorkspace_diameter(Integer.valueOf(tokens[1]));
				}
				if (tokens[0].equals("functional_offset2")) {
					specs.get(specsIndex).setLm1_offset(Integer.valueOf(tokens[1]));
				}
				if (tokens[0].equals("functional_offset3")) {
					int data = Integer.valueOf(tokens[1]);
					if(data == -1)
						specs.get(specsIndex).setLm2_offset((specs.get(specsIndex).getLandmark3().sub(specs.get(specsIndex).getLandmark2())).length());
					else
						specs.get(specsIndex).setLm2_offset(data);
				}
				if (tokens[0].equals("end")) {
					specsIndex++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void processData(List<String> data) {
		for (String line : data) {
			String[] tokens = line.split("=| |\t");
			tokens = removeEmptyStrings(tokens);

			if (tokens.length == 0 || tokens[0].startsWith("#"))
				continue;

			if (tokens[0].equals("output_config_result")) {
				Constants.getConstants().setImageOutput(tokens[1]);
			}
			if (tokens[0].equals("output_config_display")) {
				Constants.getConstants().setDataOutput(tokens[1]);
			}
			if (tokens[0].equals("single_function_runtime")) {
				Constants.getConstants().setFunction_runtime(Integer.valueOf(tokens[1]));
			}
			if (tokens[0].equals("max_dynamic_functions")) {
				Constants.getConstants().setMax_functions(Integer.valueOf(tokens[1]));
			}
		}
	}

	private static String[] removeEmptyStrings(String[] data) {
		ArrayList<String> result = new ArrayList<String>();

		for (int i = 0; i < data.length; i++) {
			if (!data[i].equals(""))
				result.add(data[i]);
		}

		String[] res = new String[result.size()];
		result.toArray(res);

		return res;
	}

	public ArrayList<Specifications> getSpecifications() {
		return specs;
	}
}
