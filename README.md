# iFix2

<p>
  <img src="https://img.shields.io/badge/Java-17-orange?logo=openjdk&logoColor=white" alt="Java 17"/>
  <img src="https://img.shields.io/badge/Swing-GUI-blue" alt="Swing"/>
  <img src="https://img.shields.io/badge/MySQL-JDBC-4479A1?logo=mysql&logoColor=white" alt="MySQL"/>
  <img src="https://img.shields.io/badge/PDF-OpenPDF-red" alt="OpenPDF"/>
  <img src="https://img.shields.io/badge/Build-Maven-C71A36?logo=apachemaven&logoColor=white" alt="Maven"/>
  <img src="https://img.shields.io/badge/status-en%20producción-brightgreen" alt="Estado"/>
</p>

Aplicación de escritorio en Java para la gestión integral de un taller de reparación de dispositivos electrónicos (móviles, tablets, ordenadores). Desarrollada como encargo real para un taller en funcionamiento, gestiona clientes, dispositivos, reparaciones, generación de documentación legal y facturación desde una interfaz de escritorio con persistencia en MySQL.

## Índice

- [Motivación](#motivación)
- [Funcionalidades](#funcionalidades)
- [Arquitectura y modelo de datos](#arquitectura-y-modelo-de-datos)
- [Decisiones técnicas destacadas](#decisiones-técnicas-destacadas)
- [Stack técnico](#stack-técnico)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Capturas](#capturas)
- [Puesta en marcha](#puesta-en-marcha)
- [Roadmap](#roadmap)
- [Autor](#autor)

## Motivación

El taller gestionaba clientes, reparaciones y cobros de forma manual (papel y hojas de cálculo sueltas), sin trazabilidad ni forma rápida de consultar el histórico de un cliente o dispositivo. iFix2 centraliza toda esa información en una única aplicación con base de datos relacional, generación automática de documentación (recibos y facturas) y control de reparaciones en curso — sustituyendo un proceso manual por una herramienta que el negocio usa a diario.

## Funcionalidades

| | Funcionalidad | Descripción |
|---|---|---|
| 👤 | **Gestión de clientes** | Alta, edición y consulta de clientes con datos de contacto y fiscales. |
| 📱 | **Gestión de dispositivos** | Cada dispositivo queda vinculado a un cliente, con marca, modelo, IMEI y código de desbloqueo. |
| 🔧 | **Gestión de reparaciones** | Registro de reparaciones por dispositivo, con fechas, estado, garantía y comentarios. |
| 🧾 | **Líneas de reparación (N:M)** | Una reparación puede incluir múltiples conceptos, cada uno con su propio precio, permitiendo desglosar el importe total. |
| 📝 | **Recibí de entrega en PDF** | Documento generado al recibir el dispositivo, con datos del cliente, del dispositivo, diagnóstico, condiciones del servicio y espacio de firma — ver detalle abajo. |
| 📄 | **Facturación en PDF** | Genera una factura profesional a partir de una reparación finalizada, con desglose de IVA — ver detalle abajo. |
| 🗄️ | **Persistencia con JDBC puro** | Acceso a datos mediante SQL directo (sin ORM), con capa DAO propia. |

**Detalle del recibí de entrega:**
- Bloques separados con los datos del cliente y del dispositivo
- Listado de los tipos de reparación solicitados
- Espacio para el código de desbloqueo o el patrón de pantalla, con rejilla visual para dibujarlo
- Condiciones del servicio y exención de responsabilidad
- Espacios de firma para la recogida y la conformidad del cliente

**Detalle de la factura generada:**
- Datos fiscales del taller y del cliente en bloques visualmente separados
- Desglose completo de los conceptos reparados
- Cálculo automático de base imponible e IVA (21 %) a partir del importe total
- Diseño maquetado con tablas, cabeceras y pie de página, listo para imprimir o enviar al cliente

## Arquitectura y modelo de datos

```
Cliente 1---N Dispositivo 1---N Reparacion 1---N LineaReparacion N---1 TipoReparacion
```

- Un **Cliente** puede tener varios **Dispositivos**.
- Un **Dispositivo** puede tener varias **Reparaciones** a lo largo del tiempo (histórico), y almacena su propio código de desbloqueo, ya que es un dato asociado al aparato, no a una visita concreta.
- Una **Reparación** se compone de una o varias **LineaReparacion**, cada una asociada a un **TipoReparacion** con su precio, lo que permite reparaciones con múltiples conceptos facturables (ej. cambio de pantalla + batería en la misma visita).

El esquema fue diseñado y refactorizado específicamente para resolver este modelo N:M de forma limpia, evitando duplicidad de datos entre reparaciones con conceptos similares.

## Decisiones técnicas destacadas

Algunas decisiones de diseño tomadas durante el desarrollo, documentadas aquí porque reflejan el criterio aplicado, no solo el resultado final:

- **Ubicación del código de desbloqueo**: se valoró guardarlo en `Reparacion` (por visita) o en `Dispositivo` (persistente). Se optó por `Dispositivo`, priorizando tener siempre el dato más reciente accesible frente a conservar un histórico que, en este caso de uso, no aportaba valor real al negocio.
- **Separación de Recibí y Factura**: aunque comparten parte del modelo de datos, son documentos con propósitos y momentos distintos (entrada vs. cierre de la reparación), por lo que se implementaron como generadores independientes en lugar de forzar un único documento configurable.
- **JDBC puro frente a un ORM**: se optó por acceso a datos con SQL directo para mantener control explícito sobre las consultas, especialmente relevante en el modelo N:M de líneas de reparación.

## Stack técnico

| Capa | Tecnología |
|---|---|
| Lenguaje | Java 17 |
| Interfaz | Swing |
| Persistencia | JDBC + SQL puro (MySQL) |
| Generación de PDF | OpenPDF |
| Build | Maven |

## Estructura del proyecto

```
src/main/java/
├── modelo/          # Clases de dominio: Cliente, Dispositivo, Reparacion, LineaReparacion, etc.
├── dao/             # Acceso a datos (JDBC)
├── vista/           # Interfaces Swing
└── util/            # Generadores de PDF (factura, recibí), utilidades
src/main/resources/
└── patron_rejilla.png   # Recurso gráfico usado en el recibí
```

*(ajustar según la estructura real de paquetes del proyecto)*

## Capturas

> _Pendiente de añadir capturas de la interfaz principal, el formulario de reparación, el recibí y un ejemplo de factura generada._

## Puesta en marcha

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/CarlosRiberaDonet/iFix2.git
   ```
2. Crear la base de datos MySQL y ejecutar el script de esquema (`/sql/schema.sql`.
3. Configurar las credenciales de conexión en `[ruta del archivo de configuración]`.
4. Compilar y ejecutar con Maven:
   ```bash
   mvn clean install
   mvn exec:java
   ```

## Roadmap

- [ ] Impresión de etiquetas térmicas (nº de seguimiento, avería, contraseña/patrón del dispositivo) — pendiente de adquisición de impresora dedicada.
- [ ] Captura táctil del patrón de desbloqueo en pantalla, sustituyendo la rejilla estática por el patrón real dibujado por el cliente.
- [ ] Firma digital del cliente en pantalla táctil, aceptando términos y condiciones del servicio.
- [ ] Sistema de roles (Dependienta / Master) con distintos niveles de acceso a costes y balance.
- [ ] API REST para consulta remota de estado de pago desde otras tiendas asociadas.
- [ ] Adaptación a la normativa VeriFactu (obligatoria en España a partir de 2027 para autónomos).

## Autor

**Carlos Ribera Donet**
Software Developer — [LinkedIn](https://www.linkedin.com/in/carlos-r-335390276/) · [GitHub](https://github.com/CarlosRiberaDonet)
