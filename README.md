
# Gestor de Tareas con Hashing y Resolución de Colisiones

Este proyecto implementa un sistema de gestión de tareas utilizando una tabla hash para almacenamiento eficiente, incluyendo técnicas de hashing y resolución de colisiones (lineal y cuadrática).

## Archivos

- **`Main.java`**: Programa principal con un menú interactivo para ingresar, mostrar, editar o eliminar tareas.
- **`Hash.java`**: Clase que implementa la tabla hash con métodos de inserción, búsqueda, eliminación y edición de tareas.
- **`Tareas.java`**: Define el objeto `Tareas` con atributos como ID, nombre, descripción, fechas y estado.
- **`Colision.java`**: Implementa dos métodos para la resolución de colisiones: lineal y cuadrática.

## Funcionalidades

- **Ingreso de tareas** con atributos: nombre, descripción, fecha de finalización y estado.
- **Generación automática de ID** utilizando UUID.
- **Almacenamiento en tabla hash** con dos opciones de hashing:
  - Aritmética modular
  - Método de multiplicación
- **Manejo de colisiones** mediante:
  - Exploración lineal
  - Exploración cuadrática
- **Búsqueda, edición y eliminación** de tareas usando su ID parcial (10 caracteres).
- **Visualización** de tareas almacenadas.


## Notas

- La búsqueda, edición y eliminación requieren ingresar los **primeros 10 caracteres del ID** de la tarea.
- La fecha de finalización debe ingresarse en formato `AAAA-MM-DD`.
- Las tareas pueden tener los siguientes estados:
  - Pendiente
  - En curso
  - Terminada

## Prueba al insertar
- Se ingresa los datos que debe tener la tarea y cuando se pide la fecha se ingresa un try-catch para que salve el codigo por si llega a haber una excepcion.
  ![Captura de pantalla 2025-05-12 222537](https://github.com/user-attachments/assets/87d87aed-d851-4278-b131-bfdbff9a539b)

- Luego se pasa por una funcion hash la cual es la que se pide al inicio del codigo, y calcula el indice. En caso de estar ocupado se resuelve con la colision elegida al comienzo del codigo.
  
![Captura de pantalla 2025-05-12 223157](https://github.com/user-attachments/assets/2d9d8fb7-8397-4fca-9b20-5f8d736f72d5)
