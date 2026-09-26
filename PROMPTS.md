# PROMPTS — Cancelar una reserva (TecsupFit)



### Prompt 1 — Permitir cancelar una reserva

- Proyecto: app de gimnasio "TecsupFit" en Android (Kotlin + Jetpack Compose).
- Actualmente la app solo permite agregar reservas de clases, pero no permite
  deshacerlas. Se necesita que el usuario pueda cancelar una reserva que ya haya
  hecho: debe existir una forma de quitar una clase de su lista de reservas desde
  la pantalla "Mis reservas".
- Requerimientos funcionales:
  - La pantalla de reservas debe ofrecer una acción para eliminar una reserva.
  - Al eliminar, la clase debe desaparecer de la lista de reservas.
  - La acción debe quedar conectada al estado real de reservas de la app
    (no ser solo visual).
- Criterio de aceptación: el usuario puede eliminar una reserva existente y la
  lista se actualiza correctamente.

### Prompt 2 — Confirmar antes de cancelar


- Ahora se necesita evitar cancelaciones accidentales: al momento de querer
  cancelar una reserva, la app debe pedir confirmación al usuario antes de
  eliminarla.
- Requerimientos funcionales:
  - Mostrar un diálogo de confirmación antes de cancelar la reserva.
  - El diálogo debe indicar claramente qué reserva se va a cancelar.
  - Debe ofrecer dos opciones: confirmar la cancelación o cancelar la operación
    (mantener la reserva).
  - Solo al confirmar se elimina la reserva; si el usuario rechaza, no pasa nada.
- Criterio de aceptación: al cancelar se muestra una confirmación y la reserva
  solo se elimina si el usuario la acepta.

### Prompt 3 — Estado vacío y verificación del flujo completo

- Falta el detalle final de la experiencia: cuando el usuario no tiene ninguna
  reserva, la pantalla queda vacía. Se necesita que muestre un mensaje amigable
  indicando que no hay reservas.
- Requerimientos funcionales:
  - Si la lista de reservas está vacía, mostrar un mensaje claro (por ejemplo
    "Aún no tienes reservas") en lugar de una pantalla en blanco.
  - Revisar que todo el flujo (reservar → ver reserva → cancelar con confirmación
    → lista vacía) funcione de principio a fin y sin errores.
- Criterio de aceptación: la pantalla de reservas nunca se ve vacía sin contexto
  y el flujo completo funciona correctamente.

---


## Ajustes y correcciones realizadas


   Tras el Prompt 3, se tuvo que reemplazar el texto "Cancelar" de cada reserva
   por un icono de contenedor de basura. 

