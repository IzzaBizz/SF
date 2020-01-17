package de.jamus.scheme;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SchemePort extends StElem implements ISchemePort {
	FileReader open_file_reader;
	BufferedReader open_buffer_reader;
	FileWriter open_file_writer;
	BufferedWriter open_buffer_writer;

	int number_read_call; // aktueller read Aufruf
	int number_read_data; // aktuelle datan Zeile

	String port_description;

	public SchemePort(String d) {
		super();
		port_description = d;
	}

	public SchemePort(FileReader f, BufferedReader b, String d) {
		super();
		try {
			open_file_reader = f;
			open_buffer_reader = b;
			port_description = d;
			number_read_call = 0;
			number_read_data = 0;
			// open_buffer_reader.markSupported();
			open_buffer_reader.mark(1000000); // Buffergroesse
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void resetBufferedReader() {
		try {
			open_buffer_reader.reset();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public String getPortDescription() {
		return port_description;
	}

	public SchemePort(FileWriter f, BufferedWriter b, String d) {
		super();
		open_file_writer = f;
		open_buffer_writer = b;
		port_description = d;
	}

	public SchemePort(FileReader f, BufferedReader b) {
		super();
		open_file_reader = f;
		open_buffer_reader = b;
	}

	public SchemePort(FileWriter f, BufferedWriter b) {
		super();
		open_file_writer = f;
		open_buffer_writer = b;
	}

	public FileReader getFileReader() {
		return open_file_reader;
	}

	public FileWriter getFileWriter() {
		return open_file_writer;
	}

	public BufferedWriter getBufferedWriter() {
		return open_buffer_writer;
	}

	/*
	 * public SchemeObject write(){ return RunEnv.nilval; }
	 */

	@Override
	public String sprint() {
		return "#<port>";
	}

	@Override
	public ISchemeObject printp(BufferedWriter open_buffer_writer) {
		return RunEnv.nilval;
	}

	public Symbol stringsymbol() {
		return new Symbol("SchemePort");
	}

	@Override
	public ISchemeObject eval() {
		return this;
	}
}
