# Proyecto AgroEasy Implementando Clean Architecture

## Necesario

- **JDK 11**
- **POSTGRESQL 14**
- **Gradle 6 o Superior**
- **Intellij IDEA ULTIMA VERSION**

## Correr el proyecto en local

Abrir el proyecto en Intellij y configurar de la siguiente forma:

### settings > Build > Compiler

- **En java compiler nos aseguramos que este en la version 11**
- **En la seccion de Annotation Processors marcamos como Enable**

### settings > Build > Build Tools > Gradle

- **Nos aseguramos que este la version de gradle que tengamos intalada**

Por ultimo debemos colocar las credenciales de la base de datos en el archivo application.yml dentro del modulo
app-service y la carpeta resoruce y podemos correr el proyecto desde el main application o configurandolo desde el Run.

# Arquitectura

![Clean Architecture](https://miro.medium.com/max/1400/1*ZdlHz8B0-qu9Y-QO3AXR_w.png)

## Domain

Es el m�dulo m�s interno de la arquitectura, pertenece a la capa del dominio y encapsula la l�gica y reglas del negocio
mediante modelos y entidades del dominio.

## Usecases

Este m�dulo gradle perteneciente a la capa del dominio, implementa los casos de uso del sistema, define l�gica de
aplicaci�n y reacciona a las invocaciones desde el m�dulo de entry points, orquestando los flujos hacia el m�dulo de
entities.

## Infrastructure

### Helpers

En el apartado de helpers tendremos utilidades generales para los Driven Adapters y Entry Points.

Estas utilidades no est�n arraigadas a objetos concretos, se realiza el uso de generics para modelar comportamientos
gen�ricos de los diferentes objetos de persistencia que puedan existir, este tipo de implementaciones se realizan
basadas en el patr�n de
dise�o [Unit of Work y Repository](https://medium.com/@krzychukosobudzki/repository-design-pattern-bc490b256006)

Estas clases no puede existir solas y debe heredarse su compartimiento en los **Driven Adapters**

### Driven Adapters

Los driven adapter representan implementaciones externas a nuestro sistema, como lo son conexiones a servicios rest,
soap, bases de datos, lectura de archivos planos, y en concreto cualquier origen y fuente de datos con la que debamos
interactuar.

### Entry Points

Los entry points representan los puntos de entrada de la aplicaci�n o el inicio de los flujos de negocio.

## Application

Este m�dulo es el m�s externo de la arquitectura, es el encargado de ensamblar los distintos m�dulos, resolver las
dependencias y crear los beans de los casos de use (UseCases) de forma autom�tica, inyectando en �stos instancias
concretas de las dependencias declaradas. Adem�s inicia la aplicaci�n (es el �nico m�dulo del proyecto donde
encontraremos la funci�n �public static void main(String[] args)�.

**Los beans de los casos de uso se disponibilizan automaticamente gracias a un '@ComponentScan' ubicado en esta capa.**
