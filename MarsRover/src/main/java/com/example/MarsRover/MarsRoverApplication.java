package com.example.MarsRover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Scanner;

import static com.example.MarsRover.InstructionParser.parseGrid;
import static com.example.MarsRover.InstructionParser.parsePosition;

@SpringBootApplication
public class MarsRoverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarsRoverApplication.class, args);
			ArrayList<Rover> rovers = new ArrayList<>();
			Scanner scanner = new Scanner(System.in);
			Grid grid = parseGrid(scanner.nextLine());
			while(scanner.hasNext()) {
				String currentLine = scanner.nextLine();
				if (currentLine.equalsIgnoreCase("exit"))
					break;
				Rover rover = new Rover(grid, parsePosition(currentLine));
				rovers.add(rover);
				//System.out.println("rover added");
				rover.process(scanner.nextLine());
				//System.out.println(rover.getPosition());
			}
			rovers.forEach(r -> System.out.println(r.getPosition()));
	}

}
