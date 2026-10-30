# Casos de Prueba - Grupo 3

1. **Registro de Ruta y Capacidad:**
   - *Entrada:* Crear ruta R01 de B01 a B02 con capacidad 50.
   - *Resultado Esperado:* Ruta registrada exitosamente.
   - *Resultado Obtenido:* Correcto.

2. **Caso Obligatorio de Límite de Ruta:**
   - *Entrada:* Ruta con capacidad 50 y uso actual 35. Intentar despacho de 20 unidades.
   - *Resultado Esperado:* Rechazado por exceder la capacidad máxima de la ruta (35 + 20 = 55 > 50)[cite: 5].
   - *Resultado Obtenido:* Correcto ("Rechazado: La ruta excede su capacidad máxima...").

3. **Verificación de Stock Insuficiente:**
   - *Entrada:* Intentar despachar 15 unidades cuando el origen solo tiene 10.
   - *Resultado Esperado:* Mensaje de error por stock insuficiente.
   - *Resultado Obtenido:* Correcto.

4. **Despacho Exitoso:**
   - *Entrada:* Despachar 10 unidades de P01 de B01 a B02 (origen con 40 de stock, ruta con uso 35 y capacidad 50).
   - *Resultado Esperado:* Despacho exitoso, origen con 30, destino con 10, ruta con uso 45.
   - *Resultado Obtenido:* Correcto.

5. **Detección de Rutas Saturadas:**
   - *Entrada:* Consultar rutas saturadas tras un uso total de la capacidad.
   - *Resultado Esperado:* Mostrar la ruta marcada como saturada.
   - *Resultado Obtenido:* Correcto.
