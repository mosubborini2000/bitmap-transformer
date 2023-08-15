# Bitmap Transformation App

The Bitmap Transformation App is a Java application designed to perform various transformations on bitmap images. This application provides functionality to read bitmap images, apply different image transformations, and save the modified images.

## Features

The Bitmap Transformation App currently supports the following transformations:

### Gray Conversion
Converts a given bitmap image to grayscale. This transformation calculates the average value of the red, green, and blue components of each pixel and sets all three components to that average value, resulting in a grayscale effect.

### Color Inversion
Inverts the colors of a given bitmap image. This transformation subtracts the red, green, and blue component values of each pixel from 255, creating a color-negative effect.

### Rotation
Rotates a given bitmap image by 90 degrees clockwise. This transformation rearranges the pixel data in a way that the image appears rotated by 90 degrees.

## Usage

To use the Bitmap Transformation App, follow these steps:

1. Compile the Java source files using a Java compiler or a build tool like Gradle.
2. Run the compiled application with appropriate command-line arguments:

- `input_image.bmp`: Path to the input bitmap image.
- `output_image.bmp`: Path to save the modified output image.
- `transformation`: Choose from "gray", "invert", or "rotate" to specify the transformation.

## Running Tests

The application includes unit tests to ensure the correctness of the implemented transformations. The tests are written using the JUnit framework and can be executed:
Run the tests.