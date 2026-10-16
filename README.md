# PayFlow — Gestión de nómina

PayFlow es un proyecto de consola para practicar programación orientada a objetos en Java 17. Modela varios tipos de empleados, calcula sus pagos mensuales y genera boletas y totales de nómina.

## Requisitos

- JDK 17
- Apache Maven 3.6 o posterior para ejecutar desde la línea de comandos
- IntelliJ IDEA (Community o Ultimate), opcional

## Estructura

El proyecto sigue la estructura estándar de Maven:

```text
src/main/java/com/nttdata/payflow/
├── Main.java
├── model/
│   ├── Area.java
│   ├── Boleta.java
│   ├── Bonificable.java
│   ├── Empleado.java
│   ├── EmpleadoPlanilla.java
│   ├── EmpleadoPorHoras.java
│   ├── Gerente.java
│   └── Practicante.java
├── servicio/
│   └── Nomina.java
└── validacion/
    └── Validador.java
```

- `model`: contiene las áreas, la abstracción de empleado y sus implementaciones, además del contrato de bonificación y el record de boleta.
- `servicio/Nomina`: administra empleados, evita identificadores duplicados, calcula totales y genera boletas.
- `Main`: crea datos de ejemplo y muestra los resultados en consola.
- `validacion/Validador`: ejecuta 20 verificaciones automáticas de las reglas del proyecto.

## Reglas de pago implementadas

- **Planilla:** sueldo base, asignación familiar de 100.00 si tiene hijos y bono de desempeño del 10% cuando la evaluación es 4 o 5.
- **Por horas:** hasta 160 horas a tarifa normal; las horas adicionales se pagan al 150% de la tarifa.
- **Gerente:** pago de planilla más un bono de gestión del 20% del sueldo base.
- **Practicante:** subvención mensual fija.
- La nómina rechaza identificadores duplicados y expone su lista de empleados como no modificable.

## Ejecutar con Maven

Desde la carpeta que contiene `pom.xml`, compila el proyecto:

```powershell
mvn clean package
```

Ejecuta la demostración:

```powershell
java -cp target\classes com.nttdata.payflow.Main
```

Para ejecutar las verificaciones automáticas:

```powershell
java -cp target\classes com.nttdata.payflow.validacion.Validador
```

El validador debe finalizar con `PUNTAJE AUTOMÁTICO: 20 / 20`. El ejemplo de `Main` muestra una nómina total de `18500.00` y un total de área TI de `13800.00`.

## Ejecutar desde IntelliJ IDEA

1. Abre en IntelliJ la carpeta que contiene `pom.xml` y acepta la importación como proyecto Maven.
2. En **File > Project Structure > Project**, selecciona un JDK 17 como Project SDK.
3. Ejecuta `com.nttdata.payflow.validacion.Validador` para comprobar las reglas.
4. Ejecuta `com.nttdata.payflow.Main` para mostrar las boletas y los totales.
