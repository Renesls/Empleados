# Sistema de Gestión de Empleados - Jakarta EE + JPA

Aplicación simple de consola para gestionar empleados y cargos usando **Jakarta Persistence API (JPA)**.

## 📋 Requisitos

- Java JDK 17 o superior
- Maven 3.8+

## 🚀 Cómo Ejecutar

1. **Compilar el proyecto:**
```bash
mvn clean compile
```

2. **Ejecutar la aplicación:**
```bash
mvn exec:java -Dexec.mainClass="com.example.empleados.Main"
```

O desde tu IDE (IntelliJ IDEA, Eclipse, etc.), simplemente ejecuta la clase `Main.java`

## 📦 Estructura del Proyecto

```
src/main/java/com/example/empleados/
├── Main.java              # Clase principal con método main
└── model/                 # Entidades JPA
    ├── Cargo.java        # Entidad Cargo
    └── Empleado.java     # Entidad Empleado

src/main/resources/META-INF/
└── persistence.xml        # Configuración JPA
```

## 🔧 Tecnologías

- **Jakarta Persistence API (JPA) 3.2** - Persistencia de datos
- **Hibernate 6.6** - Implementación de JPA
- **H2 Database** - Base de datos en memoria
- **Maven** - Gestión de dependencias

## 📝 Qué hace la aplicación

Al ejecutar, la aplicación:
1. Crea un cargo "Desarrollador"
2. Crea un empleado "Juan Pérez"
3. Asigna el cargo al empleado
4. Muestra mensajes en consola confirmando cada operación

## 📊 Salida Esperada

```
Cargo guardado: Desarrollador
Empleado guardado: Juan Pérez
Asignación creada: Juan -> Desarrollador
Empleado Juan asignado a Desarrollador

¡Proceso completado exitosamente!
```

## 💡 Modificar la Aplicación

Puedes editar el archivo `Main.java` para:
- Crear más empleados y cargos
- Consultar datos guardados
- Actualizar información
- Eliminar registros

Ejemplo de consulta:
```java
List<Empleado> empleados = em.createQuery("SELECT e FROM Empleado e", Empleado.class)
    .getResultList();
empleados.forEach(e -> System.out.println(e.getNombreCompleto()));
```

## 🗄️ Base de Datos

La aplicación usa H2 en memoria, lo que significa que los datos se pierden al cerrar el programa.

Para persistir los datos, cambia en `persistence.xml`:
```xml
<property name="jakarta.persistence.jdbc.url" 
          value="jdbc:h2:~/empleadosdb"/>
```

---

**¡Listo para usar!** 🎉

