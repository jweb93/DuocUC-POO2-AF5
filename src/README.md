![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# 🧠 Actividad Formativa 5 – Desarrollo Orientado a Objetos II

## 💻 Proyecto: SpeedFast
## 👤 Autor del proyecto
- **Nombre completo:** Javier Rojas
- **Sección:** PRY2203-001A
- **Carrera:** Analista Programador Computacional
- **Sede:** Online

---

## 📘 Descripción general del sistema
Este proyecto da respuesta a la Actividad Formativa 5 de la asignatura
*Desarrollo Orientado a Objetos II*: Conectando aplicaciones Java con bases de datos
 mediante JDBC.

Se desarrolló un programa que permite la gestión (creacion y lectura) visual de
Pedidos y Repartidores mediante Java Swing y persistencia de información mediante
el uso de JDBC para realizar conexión a una BBDD MySQL. Adicionalmente se incorporó
la gestión de Entregas a nivel de objetos (no se incluye gestión visual).

El sistema creado se organiza en paquetes, aplica principios de
composición (clase Dirección), encapsulamiento (atributos privados y
métodos getter/setter) y mantiene documentación de código usando Javadocs.


---

## 🧱 Estructura general del proyecto

```plaintext
docs
└── index.html
src
├── README.md
├── main
│   ├── java
│   │   ├── Main.java
│   │   ├── controlador
│   │   │   └── GestorDatos.java
│   │   ├── dao
│   │   │   ├── ConexionBD.java
│   │   │   ├── EntregaDAO.java
│   │   │   ├── PedidoDAO.java
│   │   │   └── RepartidorDAO.java
│   │   ├── modelo
│   │   │   ├── Direccion.java
│   │   │   ├── Entrega.java
│   │   │   ├── EstadoPedido.java
│   │   │   ├── Pedido.java
│   │   │   ├── Repartidor.java
│   │   │   ├── TipoPedido.java
│   │   │   └── ZonaDeCarga.java
│   │   └── vista
│   │       ├── VentanaDespacho.java
│   │       ├── VentanaListaPedidos.java
│   │       ├── VentanaListaRepartidores.java
│   │       ├── VentanaPrincipal.java
│   │       ├── VentanaRegistroPedido.java
│   │       └── VentanaRegistroRepartidor.java
│   └── resources
└── test
    └── java
````

---


## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Clone el repositorio desde GitHub:

```bash
git clone https://github.com/jweb93/DuocUC-POO2-AF5.git
```

2. Abra el proyecto en IntelliJ IDEA.

3. Ejecute el archivo `Main.java` desde la ruta src/main/java.

4. Puede revisar la documentación del código accediendo al
   archivo `docs/index.html`

---

**Repositorio GitHub:** https://github.com/jweb93/DuocUC-POO2-AF5
**Fecha de entrega:** \[21/09/2026]

---

© Duoc UC | Escuela de Informática y Telecomunicaciones 




