# TecsupFit

Aplicación móvil de gimnasio desarrollada en **Android** con **Kotlin** y **Jetpack Compose**. Permite a los usuarios explorar las clases disponibles, reservar un cupo, gestionar sus reservas, ver sus rutinas y revisar su perfil.

## Descripción

TecsupFit es una app sencilla e intuitiva para miembros de un gimnasio. Desde la pantalla de inicio, el usuario puede ver las clases disponibles (Yoga funcional, Cross Training y Spinning), filtrarlas y entrar al detalle de cada una para conocer su horario, sala, descripción y cupos. Al reservar una clase, recibe una confirmación y puede consultar todas sus reservas en una sección dedicada, donde también puede cancelarlas si ya no las necesita. Además, cuenta con una sección de rutinas y un perfil personal.


## Requerimientos funcionales

1. **Explorar clases disponibles**
   - El usuario puede ver la lista de clases del gimnasio desde la pantalla de inicio.
   - Puede filtrar las clases entre "Hoy" y "Esta semana".

2. **Ver el detalle de una clase**
   - Al tocar una clase, se muestra su información completa: nombre, horario, sala, descripción y cupos disponibles.

3. **Reservar un cupo**
   - Desde el detalle de la clase, el usuario puede reservar un cupo con el botón "Reservar cupo".
   - Al reservar, se muestra una pantalla de confirmación con el mensaje "¡Cupo reservado!" y los datos de la clase.
   - No se puede reservar dos veces la misma clase (evita reservas duplicadas).

4. **Ver las reservas**
   - La pantalla "Mis reservas" muestra todas las clases que el usuario ha reservado.
   - Cada reserva indica el nombre, horario, sala y el estado "Confirmada".

5. **Cancelar una reserva con confirmación**
   - Cada reserva tiene un botón (icono de papelera) para cancelarla.
   - Antes de eliminar, la app muestra un diálogo de confirmación que indica qué reserva se va a cancelar.
   - Solo se elimina si el usuario confirma; si elige "No", la reserva se mantiene.

6. **Estado vacío de reservas**
   - Si el usuario no tiene reservas, la pantalla muestra el mensaje "Aún no tienes reservas" en lugar de una pantalla en blanco.

7. **Ver rutinas**
   - La sección "Mis rutinas" muestra una lista de rutinas disponibles (fuerza, cardio y movilidad).

8. **Ver el perfil**
   - La sección "Mi perfil" muestra la información básica del usuario: nombre, plan y estadísticas (clases y rachas).

