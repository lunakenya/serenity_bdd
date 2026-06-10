# language: es

@flujo_compra
Característica: Flujo de compra en Demoblaze
  Como usuario de la tienda Demoblaze
  Quiero poder agregar productos al carrito y completar una compra
  Para adquirir los productos seleccionados de forma exitosa

  @compra_exitosa @smoke @critical @e2e
  Escenario: Compra exitosa agregando dos productos al carrito
    Dado que el usuario abre la página de Demoblaze
    Cuando agrega el producto "Samsung galaxy s6" al carrito
    Y agrega el producto "Nokia lumia 1520" al carrito
    Y visualiza el carrito de compra
    Entonces debe ver los productos seleccionados en el carrito
      | Samsung galaxy s6 |
      | Nokia lumia 1520  |
    Cuando completa el formulario de compra con los datos registrados
    Y finaliza la compra
    Entonces debe visualizar el mensaje de confirmación "Thank you for your purchase!"

  @formulario_incompleto @negative @regression
  Escenario: Intento de compra con formulario incompleto
    Dado que el usuario abre la página de Demoblaze
    Cuando agrega el producto "Samsung galaxy s6" al carrito
    Y visualiza el carrito de compra
    Y hace clic en realizar pedido sin completar el formulario
    Entonces no debe procesarse la compra sin datos obligatorios

  @multiples_productos @outline @regression
  Esquema del escenario: Verificar que cada producto se puede agregar al carrito individualmente
    Dado que el usuario abre la página de Demoblaze
    Cuando agrega el producto "<producto>" al carrito
    Y visualiza el carrito de compra
    Entonces debe ver los productos seleccionados en el carrito
      | <producto> |

    Ejemplos:
      | producto           |
      | Samsung galaxy s6  |
      | Nokia lumia 1520   |
