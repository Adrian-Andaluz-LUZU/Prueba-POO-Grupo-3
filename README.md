# Prueba-POO-Grupo-3

## Integrantes
- Adrián Andaluz
- Paulo Escobar
- Mateo Salazar
- Ariel Chanatasig

## Objetivo
Construir una aplicación de consola funcional en Java aplicando Programación Orientada a Objetos (POO) para resolver un sistema de distribución de mercancías entre bodegas mediante rutas de capacidad limitada, implementando validaciones de stock y control de rutas saturadas[cite: 1, 5].

## Clases y Métodos Principales
- **Producto:** Gestiona los atributos básicos (código y nombre) de la mercancía.
- **Bodega:** Administra el inventario de productos por medio de un `HashMap`, permitiendo agregar y reducir stock de forma segura[cite: 5].
- **Ruta:** Controla las conexiones entre bodegas, evaluando la capacidad máxima, el uso actual y detectando rutas saturadas[cite: 5].
- **Distribuidor:** Clase lógica que coordina las colecciones de bodegas y rutas, procesando los despachos y validando existencias[cite: 5].
- **Main:** Controla la interfaz de usuario mediante un menú interactivo con bucles y opciones de consola[cite: 1, 5].

## Compilación y Ejecución
1. Abra el proyecto en Visual Studio Code[cite: 1].
2. Ubíquese dentro de la carpeta `src/`.
3. Compile todos los archivos `.java` o ejecute directamente la clase `Main.java`.

## Capturas de Ejecución
*(Agregue aquí capturas de pantalla de su consola funcionando)*

## Distribución de Responsabilidades
- **Adrián Andaluz:** Arquitectura inicial, clase `Main` (menú interactivo) e integración general del repositorio.
- **Paulo Escobar:** Diseño y codificación de la clase `Ruta` y validaciones de capacidad.
- **Mateo Salazar:** Implementación de las clases `Producto` y `Bodega` con control de inventarios.
- **Ariel Chanatasig:** Desarrollo de la clase lógica `Distribuidor` y redacción de la documentación de casos de prueba.
