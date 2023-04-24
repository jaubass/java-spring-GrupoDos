# Objetivos
### Modificar nuestra base de datos para la gestión con usuarios

- Utilizar, configurar e implementar Spring Security para poder gestionar los diferentes usuarios.
## Pasos a seguir

Los pasos a seguir para llevar a cabo el producto son:

- Leer detenidamente estas instrucciones e identificar los requerimientos de la actividad.
- Revisar detenidamente la rúbrica de evaluación.
- Consultar los recursos necesarios facilitados en el aula.
- Modificar nuestro diagrama E/R para la incorporación de usuarios a nuestra aplicación tanto desde el punto de vista de la securización como desde el punto de vista de la lógica de la misma.
- Incorporar Spring Security dentro de la aplicación para ello:
- Se modificará las configuraciones del proyecto para incorporar Spring Security
- Incorporar el formulario de login y registro de usuario
- Se modifican las relaciones en al menos una de las entidades propuestas ya que los usuario interactuan con el resto de entidades. Por lo tanto se realizarán los siguientes cambios en la aplicación:

- Se añadirán los modelos necesarios nuevos
- Se modificarán los modelos con las anotaciones necesarias
- Se modificarán las vistas y controladores
- Se añade una gestión por roles de las diferentes partes de la aplicación. Se añaden las siguientes rutas:
una ruta “/admin/*” en la que únicamente tendrá acceso el rol ADMIN. Aquí se moverán todas las rutas que creen, modifiquen o borren filas de los diferentes modelos
una ruta “/user/*”, donde el usuario con acceso podrá interactuar con partes de la aplicación
- Realizad las modificaciones oportunas del contenedor Docker.