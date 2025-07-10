


# README - Proyecto GuayacoCar

## Descripción del Proyecto

GuayacoCar es una aplicación de marketplace de automóviles desarrollada en Java utilizando JavaFX para la interfaz gráfica. [1](#0-0)  El sistema permite a los usuarios navegar, buscar y gestionar vehículos, implementando estructuras de datos personalizadas para optimizar el rendimiento.

## Características Principales

### Gestión de Usuarios
- Sistema de autenticación con login y registro de usuarios [2](#0-1) 
- Gestión de perfiles de usuario con propiedades como nombre, apellido, correo y contraseña [2](#0-1) 

### Gestión de Vehículos
- Catálogo completo de automóviles con propiedades detalladas [3](#0-2) 
- Sistema de marcas de automóviles con modelos predefinidos [4](#0-3) 
- Funcionalidades para crear y editar información de vehículos [5](#0-4) 

### Lógica de Negocio
- Clase Sistema central que maneja toda la lógica de negocio de la aplicación [6](#0-5) 
- Sistema de persistencia de datos mediante archivos .dat [7](#0-6) 

## Estructuras de Datos Implementadas

El proyecto implementa estructuras de datos personalizadas para optimizar el rendimiento:

### Lista Doblemente Enlazada Circular
- Implementación personalizada utilizada para carruseles de imágenes y gestión de favoritos [8](#0-7) 

### ArrayList Dinámico
- Implementación personalizada de ArrayList con capacidad dinámica [9](#0-8) 

### Interfaz de Lista
- Interfaz común que define las operaciones para todas las estructuras de lista [10](#0-9) 

## Arquitectura del Sistema

### Estructura de Paquetes
```
src/main/java/
├── Bases/          # Estructuras de datos personalizadas
├── Clases/         # Modelos de datos y lógica de negocio
└── Controladores/  # Controladores de la interfaz de usuario
```

### Controladores Principales
- **App.java**: Clase principal de la aplicación JavaFX [11](#0-10) 
- **LoginController.java**: Maneja la autenticación de usuarios [12](#0-11) 
- **UsuarioController.java**: Controla la interfaz principal de navegación de vehículos [13](#0-12) 

### Modelos de Datos
- **Auto.java**: Representa un vehículo con todas sus propiedades [3](#0-2) 
- **Usuario.java**: Representa un usuario del sistema [2](#0-1) 
- **Enumeraciones**: Estado, Tipo, Motor, Transmisión, Ubicación para categorizar vehículos [14](#0-13) 

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal
- **JavaFX**: Framework para la interfaz gráfica de usuario [15](#0-14) 
- **Maven**: Herramienta de gestión de dependencias y construcción del proyecto [15](#0-14) 
- **Serialización Java**: Para persistencia de datos en archivos .dat

## Instalación y Ejecución

### Prerrequisitos
- Java JDK 11 o superior
- Maven 3.6 o superior
- JavaFX SDK

### Pasos para ejecutar
1. Clonar el repositorio
2. Navegar al directorio `ED_P1_Grupo06`
3. Ejecutar `mvn clean javafx:run` para iniciar la aplicación

## Persistencia de Datos

El sistema utiliza serialización Java para almacenar datos en archivos .dat, manejado por la clase Archivos que proporciona métodos para la gestión de usuarios y vehículos. [7](#0-6) 

## Contribuidores

Proyecto desarrollado por el Grupo 06 como parte del curso de Estructuras de Datos.

## Notas

Este proyecto es una implementación académica que demuestra el uso de estructuras de datos personalizadas en una aplicación real de marketplace de automóviles. El sistema implementa conceptos avanzados de programación orientada a objetos y estructuras de datos, incluyendo listas doblemente enlazadas circulares y arrays dinámicos optimizados para las necesidades específicas de la aplicación.
