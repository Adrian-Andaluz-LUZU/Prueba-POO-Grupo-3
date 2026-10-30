# Análisis y Diseño - Grupo 3: Distribución de productos entre bodegas

## 1. Problema
Una empresa necesita gestionar el despacho de mercancías entre distintas bodegas haciendo uso de rutas con capacidad limitada[cite: 5]. El sistema debe prevenir desabastecimientos y saturaciones en el transporte.

## 2. Entradas, Procesos y Salidas
- **Entradas:** Datos de bodegas (ID, nombre), productos (código, nombre), rutas (origen, destino, capacidad máxima) y solicitudes de despacho (cantidades y códigos de producto).
- **Procesos:** Verificación de inventario en origen, validación de capacidad disponible en las rutas, actualización matemática de inventarios y control de rutas saturadas.
- **Salidas:** Mensajes de confirmación o rechazo de despachos, inventarios actualizados, listado de rutas y reportes de saturación e historial.

## 3. Decisiones de Diseño (POO)
- Se aplicó **encapsulamiento** ocultando los atributos con modificadores `private` y exponiéndolos mediante métodos seguros.
- La clase `Distribuidor` actúa como gestor central del sistema de colecciones (`ArrayList` y `HashMap`), desacoplando la lógica de negocio de la interfaz de consola en `Main`.
