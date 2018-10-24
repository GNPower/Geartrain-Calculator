package core.files;

public class Constants {

	private int z_axis_range, max_trains, max_gears, max_print_time, print_speed;
	private String imageOutput, dataOutput;
	private int function_runtime, max_functions;
	
	public static enum Direction{
		CW, CCW;
	}
	
	private static Constants instance = null;
	
	public static Constants getConstants() {
		if(instance == null)
			instance = new Constants();
		return instance;
	}
	
	protected Constants() {
		z_axis_range = -1;
		max_trains = 50;
		max_gears = -1;
		max_print_time = 24;
		print_speed = 1;
		imageOutput = null;
		dataOutput = null;
		function_runtime = -1;
		max_functions = -1;
	}
	
	public void printConstants() {
		System.out.println("System Loaded Constants Displayed Below:");
		
		System.out.println("\n\tDesign Dependant Constants:");
		System.out.println("\t\tZ-Axis Range: " + z_axis_range + " mm");
		System.out.println("\t\tMaximin Gears: " + max_gears);
		System.out.println("\t\tMaximum Gear Trains: " + max_trains);
		
		System.out.println("\n\t3D Printer Dependant Constants:");
		System.out.println("\t\tPrinter Speed: " + print_speed + " cubic mm per second");
		System.out.println("\t\tMaximum Print Time: " + max_print_time + " hours");
		
		System.out.println("\n\tSystem Constants:");
		System.out.println("\t\tData Output File Type: " + dataOutput);
		System.out.println("\t\tImage Output File Type: " + imageOutput);
		System.out.println("\t\tAmout Of Design Alternatives Generated: " + max_functions);
		System.out.println("\t\tRuntime Limit To Generate A Design: " + function_runtime);
		
		System.out.println("\n--- End Of Constants ---");
	}

	public int getZ_axis_range() {
		return z_axis_range;
	}

	public void setZ_axis_range(int z_axis_range) {
		this.z_axis_range = z_axis_range;
	}

	public int getMax_trains() {
		return max_trains;
	}

	public void setMax_trains(int max_trains) {
		this.max_trains = max_trains;
	}

	public int getMax_gears() {
		return max_gears;
	}

	public void setMax_gears(int max_gears) {
		this.max_gears = max_gears;
	}

	public int getMax_print_time() {
		return max_print_time;
	}

	public void setMax_print_time(int max_print_time) {
		this.max_print_time = max_print_time;
	}

	public String getImageOutput() {
		return imageOutput;
	}

	public void setImageOutput(String imageOutput) {
		this.imageOutput = imageOutput;
	}

	public String getDataOutput() {
		return dataOutput;
	}

	public void setDataOutput(String dataOutput) {
		this.dataOutput = dataOutput;
	}

	public int getFunction_runtime() {
		return function_runtime;
	}

	public void setFunction_runtime(int function_runtime) {
		this.function_runtime = function_runtime;
	}

	public int getMax_functions() {
		return max_functions;
	}

	public void setMax_functions(int max_functions) {
		this.max_functions = max_functions;
	}

	public int getPrint_speed() {
		return print_speed;
	}

	public void setPrint_speed(int print_speed) {
		this.print_speed = print_speed;
	}
}
