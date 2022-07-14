# UOCarium

## Description

This project was done during the course DPOO in [UOC](https://uoc.edu) University. The aim of this project was to understand oriented object programming with the construction of a little virtual aquarium. 


## Code

The code is structured in 3 main packages:

1. **Controller**: This package enables the view and the model to communicate between them.

2. **View**: This package consists of the user interface. Here is coded all the graphic interface. In here there are 2 types of view, the *cmd* view it was configured for the early stages of the project and de *gui* view, implemented at the end for the final part of the project.

3. **Model**: This package contains all the info of the aquarium, such as the fishes, food or oder animals that live in the tanks. It provides all the necessary info to the view through the controller.

## Requeriments to execute the project

### Eclipse 
1. Install JavaSE-13

2. Install Eclipse

3. Install JavaFX and addid to the 'Preferences > Java >Build Path > User Libraries' (this can be found in Google)

4. Add the JavaFX to the project Libraris; 'Right click on the project > Properties > Java Build Path > Libraries > Add Library'.

5. Add command to execute JAvaFX with the run 'Run configuration > Arguments' and in the VM arguments box write the following:

```console
 --module-path /PATH_to_JavaFX_files/javafx-sdk-18.0.1/lib --add-modules javafx.controls,javafx.fxml
 ```

6. Execute the UOCariumApp contained in the view.gui package.
