# Caso de Estudio
## Modelaje de Organizaciones Multiagente (Modelo OMACS modificado)
El presente caso de estudio procura reforzar 3 habilidades esenciales en un
ingeniero de sistemas: (i) modelado, (ii) procesamiento, y (iii), visualización; de
información. Para ello, se presenta a continuación la descripción del servicio
(aplicación) a implementar. La Universidad de Cartagena busca desarrollar un
sistema que permita analizar el comportamiento de organizaciones multi-agente en
etapa de diseño. Organizaciones multi-agente se modelan empleando una
versión modificada del meta-modelo OMACS (ver Figura 1). 

!

Cada nodo, vértice, representa un elemento de la organización: Agents, Cababilities,
Roles, y Goals. Cada nodo se identifica con un identificador único. Cada arco, o arista,
por su parte, representa la relación que existe respecto a cada elemento: possesses,
requieres, y achieves. El modelo debe capturar las restricciones impuestas por el
mismo modelo. Específicamente, cada agente tiene un costo. La relación
possesses puede tomar un valor entre 0.0 y 1.0. La relación entre Roles y Capabilities
es representada mediante una línea entre cortada. Es importante mencionar que es
el experto o grupo de expertos los encargados de especificar cada una de las
restricciones mencionadas previamente en el modelo de interés.

## Requerimientos mínimos
El sistema, debe ofrecer los siguientes servicios:
- Un menú, en el cual el usuario tenga tres opciones: Nuevo Modelo, Abrir
Modelo, Guardar Modelo, y Cerrar Aplicación.
- Una paleta de opciones, las cuales le permitan al usuario: Adicionar
Elemento, Adicionar Relación, Seleccionar un objeto (elemento o relación),
Eliminar un objeto (elemento o relación).
- Actualizar atributos de un objeto (elemento o relación)

## Algunas consideraciones
- Al momento de guardar el modelo, el archivo debe preservar la ubicación de
cada objeto. Es decir, sus coordenadas.

## Ilustraciones
- Menú y editor gráfico
!
- Modelo de la organización multi-agente
!
