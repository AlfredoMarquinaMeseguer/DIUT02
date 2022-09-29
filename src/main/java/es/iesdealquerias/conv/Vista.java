/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iesdealquerias.conv;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 *
 * @author jv
 */
public class Vista {

    private Controlador controlador;

    Vista(Controlador controlador) {
        this.controlador = controlador;
    }

    public void convertir(String[] args) {

        ///////////////////////////////////// 1. FASE DE DEFINICIÓN
        // create Options object
        Options options = new Options();
        Option oRestar = Option.builder("r").hasArg()
                .desc("Restar arg a la temp").build();
        Option oSumar = Option.builder("s").hasArg()
                .desc("Sumar arg a la temp").build();

        OptionGroup group = new OptionGroup();
        group.addOption(oRestar);
        group.addOption(oSumar);
        options.addOptionGroup(group);
        options.addOption("h", "help", false, "display help");

        ///////////////////////////////////// 2. FASE DE PARSEO
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            ///////////////////////////////////// 3. FASE DE INTERROGACIÓN
            // Si opción -h
            if (cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("temperatura sube brrrrr y baja fiuuuuuu", options);
            } else {
                // Si conversión a pesetas
                if (cmd.hasOption("s")) {
                    int temp = Integer.parseInt(
                            cmd.getOptionValue("s"));
                    controlador.annadirTemp(temp);
                    // Si conversión a euros
                } else if (cmd.hasOption("r")) {
                    int temp = Integer.parseInt(
                            cmd.getOptionValue("r"));
                    controlador.substaerTemp(temp);
                } else {
                    controlador.consultarTemp();
                }
            }

        } catch (ParseException ex) {
            System.err.println(ex.getLocalizedMessage());

        }
    }

    public void showTemperatura(int temp) {
        if (temp > 100) {
            System.out.println("Error, has hervido el agua a más de 100º");
        } else if (temp < 0) {
            System.out.println("Error, has congelado el agua");
        } else {
            System.out.println("La temperatura actual es " + temp + "º");
        }
    }

}
