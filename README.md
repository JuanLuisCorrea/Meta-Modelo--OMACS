

Caso de Estudio

Modelaje de Organizaciones Multi-

agente (Modelo OMACS modificado)

Programa Profesional en Ingeniería de

Sistemas

Programación Orientada a Objetos

Juan C. García-Ojeda, PhD, MSc., Ing.

Docente

septiembre 29, 2021





Descripción

El presente caso de estudio procura reforzar 3 habilidades esenciales en un

ingeniero de sistemas: (i) modelado, (ii) procesamiento, y (iii), visualización; de

información. Para ello, se presenta a continuación la descripción del servicio

(aplicación) a implementar. La Universidad de Cartagena busca desarrollar un

sistema que permita analizar el comportamiento de organizaciones multi-agente en

etapa de diseño [\[1\].](#br6)[ ](#br6)Organizaciones multi-agente se modelan empleando una

versión modificada del meta-modelo OMACS (ver Figura 1).

Fig. 1. Vista de una organización multiagente en la que se adopta una versión

modificada del mata-modelo OMAC[S\[2\].](#br6)

Cada nodo, vértice, representa un elemento de la organización: *Agents*, *Cababilities*,

*Roles*, y *Goals*. Cada nodo se identifica con un identificador único. Cada arco, o arista,





por su parte, representa la relación que existe respecto a cada elemento: *possesses*,

*requieres*, y *achieves*. El modelo debe capturar las restricciones impuestas por el

mismo modelo [\[1\]\[](#br6)[3\]\[](#br6)[2\].](#br6)[ ](#br6)Específicamente, cada agente tiene un costo. La relación

*possesses* puede tomar un valor entre 0.0 y 1.0. La relación entre *Roles* y *Capabilities*

es representada mediante una línea entre cortada. Es importante mencionar que es

el experto o grupo de expertos los encargados de especificar cada una de las

restricciones mencionadas previamente en el modelo de interés [\[1\].](#br6)

Requerimientos Mínimos

El sistema, debe ofrecer los siguientes servicios:

•

•

Un menú, en el cual el usuario tenga tres opciones: Nuevo Modelo, Abrir

Modelo, Guardar Modelo, y Cerrar Aplicación.

Una paleta de opciones, las cuales le permitan al usuario: Adicionar

Elemento, Adicionar Relación, Seleccionar un objeto (elemento o relación),

Eliminar un objeto (elemento o relación).

•

Actualizar atributos de un objeto (elemento o relación).

Algunas Consideraciones

Cada grupo debe tener en cuenta las siguientes consideraciones:

•

Al momento de guardar el modelo, el archivo debe preservar la ubicación de

cada objeto. Es decir, sus coordenadas.





Ilustraciones

A continuación, se muestran algunas imágenes que pueden servir de referencia:

•

Menú y Editor Gráfico

•

Modelo de la organización multi-agente





•

Especificación del modelo en archivo.

Entregables y Fechas de Entrega

\1. Modelo del Sistema Orientado a Objetos, UML.

a. 1 de noviembre de 2021, 23:59, el espacio para subir dicho

entregable estará disponible la última semana de octubre de

\2021.

\2. Sistema Orientado a Objetos, Proyecto IDE Apache-Netbeans. ***Si el proyecto***

***es desarrollado en otro IDE no será evaluado***.

a. 1 de noviembre de 2021, 23:59, el espacio para subir dicho

entregable estará disponible la última semana de octubre de

\2021.

\3. Presentación, en Powerpoint.

a. 1 de noviembre de 2021, 23:59, el espacio para subir dicho

entregable estará disponible la última semana de octubre de

\2021.





Formato de Evaluación

Los entregables, de manera individual, contarán como actividades grupales. La

asistencia a la presentación, de exponentes como asistente, contará como actividad

individual; dentro del esquema de evaluación propuesto para el semestre actual.

Referencias

[1] Scott A. DeLoach, Walamitien Oyenan, and Eric Matson. A capabilities-based

model for adaptive organizations. Autonomous Agents and Multi-Agent

Systems, 16:13–56, 2008. 10.1007/s10458-007-9019-4.

[2] García-Ojeda JC, On modeling building-evacuation-route planning and

organization-based multiagent systems by resorting to the P-graph framework.

Tesis

Doctoral,

Universidad

de

Pannonia,

\2016.

<https://core.ac.uk/download/pdf/153334214.pdf>

[3] García-Ojeda JC, Bertok B, Friedler F, Argoti A, Fan LT (2015) A preliminary

study of the application of the P-graph methodology for organization-based

multiagent system designs: assessment. Acta Polytech Hung 12(2):103–122.

Material de Consulta

<https://docs.oracle.com/javase/tutorial/2d/index.html>

•

•

[https://www3.ntu.edu.sg/home/ehchua/programming/java/J4b_CustomGr](https://www3.ntu.edu.sg/home/ehchua/programming/java/J4b_CustomGraphics.html)

[aphics.html](https://www3.ntu.edu.sg/home/ehchua/programming/java/J4b_CustomGraphics.html)

•

•

<http://zetcode.com/gfx/java2d/>

[https://stackoverflow.com/questions/47369565/connect-two-circles-with-](https://stackoverflow.com/questions/47369565/connect-two-circles-with-a-line)

[a-line](https://stackoverflow.com/questions/47369565/connect-two-circles-with-a-line)

•

•

[http://www.java2s.com/Tutorial/Java/0261__2D-](http://www.java2s.com/Tutorial/Java/0261__2D-Graphics/AddRoundRectangleEllipseArctoashape.htm)

[Graphics/AddRoundRectangleEllipseArctoashape.htm](http://www.java2s.com/Tutorial/Java/0261__2D-Graphics/AddRoundRectangleEllipseArctoashape.htm)

[http://www.java2s.com/Tutorial/Java/0261__2D-](http://www.java2s.com/Tutorial/Java/0261__2D-Graphics/SelecttheEllipsetoMoveItintheCanvas.htm)

[Graphics/SelecttheEllipsetoMoveItintheCanvas.htm](http://www.java2s.com/Tutorial/Java/0261__2D-Graphics/SelecttheEllipsetoMoveItintheCanvas.htm)





•

•

<https://www.youtube.com/watch?v=JNHEZS1qaqg>

<https://www.youtube.com/watch?v=WgBMqE1P6Jw>

