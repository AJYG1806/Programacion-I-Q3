
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author allan
 */
public class Young_Allan_Proyecto {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        double efectivoEnCaja = 0.00;
        double ventasTotales = 0.00;
        double comprasTotales = 0.00;
        double totalVentas = 0.00;
        double totalCompras = 0.00;
        double descuento = 0.00;
        int numeroVentas = 0;
        int numeroCompras = 0;
        boolean sistemaActivo = true;
        boolean cajaAbierta = false;
        String producto1 = "1|Azúcar|30.0|25.0|50";
        String producto2 = "2|Avena|25.0|20.0|30";
        String producto3 = "3|Trigo|32.0|30.0|20";
        String producto4 = "4|Maíz|20.0|18.0|10";
        double totalVentaProd1 = 0.00;
        double totalVentaProd2 = 0.00;
        double totalVentaProd3 = 0.00;
        double totalVentaProd4 = 0.00;
        double totalCompraProd1 = 0.00;
        double totalCompraProd2 = 0.00;
        double totalCompraProd3 = 0.00;
        double totalCompraProd4 = 0.00;
        while (sistemaActivo) {
            System.out.println("Menu Principal:");
            System.out.println("1. Abrir Caja");
            System.out.println("2. Ventas");
            System.out.println("3. Compras");
            System.out.println("4. Reportes");
            System.out.println("5. Cierre de Caja");
            System.out.println("6. Salir del Sistema");
            System.out.print("Seleccione una opción: ");
            int opcion = lea.nextInt();
            switch (opcion) {
                case 1:
                    if (efectivoEnCaja > 0) {
                        System.out.print("Ingrese el efectivo a agregar en la caja: ");
                        double cantidad = lea.nextDouble();
                        efectivoEnCaja += cantidad;
                        System.out.println("Efectivo en caja actualizado: " + efectivoEnCaja);
                    } else {
                        cajaAbierta = true;
                        System.out.println("Caja abierta. Efectivo en caja: " + efectivoEnCaja);
                    }
                    break;

                case 2:
                    if (!cajaAbierta) {
                        System.out.println("Debe abrir la caja primero.");
                        break;
                    }
                    double subtotal = 0.0;
                    boolean comprando = true;
                    System.out.print("Ingrese el tipo de cliente (A, B, C): ");
                    char tipoCliente = lea.next().charAt(0);

                    while (comprando) {
                        System.out.print("Ingrese el código del producto: ");
                        int codigo = lea.nextInt();
                        String producto = "";
                        double precioVenta = 0.0;
                        int inventario = 0;

                        switch (codigo) {
                            case 1:
                                producto = producto1;
                                break;
                            case 2:
                                producto = producto2;
                                break;
                            case 3:
                                producto = producto3;
                                break;
                            case 4:
                                producto = producto4;
                                break;
                            default:
                                System.out.println("Código de producto no válido.");
                                continue;
                        }
                        int primerDelim = producto.indexOf('|');
                        int segundoDelim = producto.indexOf('|', primerDelim + 1);
                        int tercerDelim = producto.indexOf('|', segundoDelim + 1);
                        int cuartoDelim = producto.indexOf('|', tercerDelim + 1);
                        String nombre = producto.substring(primerDelim + 1, segundoDelim);
                        precioVenta = Double.parseDouble(producto.substring(segundoDelim + 1, tercerDelim));
                        inventario = Integer.parseInt(producto.substring(cuartoDelim + 1));
                        boolean puedeComprar = false;
                        switch (tipoCliente) {
                            case 'A':
                                puedeComprar = true;
                                break;
                            case 'B':
                                if (codigo == 1 || codigo == 2 || codigo == 3) {
                                    puedeComprar = true;
                                }
                                break;
                            case 'C':
                                if (codigo == 4) {
                                    puedeComprar = true;
                                }
                                break;
                        }
                        if (puedeComprar) {
                            System.out.println("Producto: " + nombre);
                            System.out.println("Precio por kg: " + precioVenta);
                            System.out.print("Ingrese la cantidad en kg a comprar: ");
                            double cantidadCompra = lea.nextDouble();

                            if (cantidadCompra <= inventario) {
                                subtotal += cantidadCompra * precioVenta;
                                inventario -= cantidadCompra;
                                switch (codigo) {
                                    case 1:
                                        totalVentaProd1 += cantidadCompra * precioVenta;
                                        break;
                                    case 2:
                                        totalVentaProd2 += cantidadCompra * precioVenta;
                                        break;
                                    case 3:
                                        totalVentaProd3 += cantidadCompra * precioVenta;
                                        break;
                                    case 4:
                                        totalVentaProd4 += cantidadCompra * precioVenta;
                                        break;
                                }
                                System.out.println("Subtotal actual: " + subtotal);
                            } else {
                                System.out.println("No hay suficiente inventario para la cantidad solicitada.");
                            }
                        } else {
                            System.out.println("NO PUEDE COMPRAR DICHO PRODUCTO.");
                        }

                        System.out.print("¿Desea comprar otro producto? (s/n): ");
                        char respuesta = lea.next().charAt(0);
                        if (respuesta == 'n' || respuesta == 'N') {
                            comprando = false;
                        }
                        String nuevoProducto = producto.substring(0, cuartoDelim + 1) + inventario;
                        switch (codigo) {
                            case 1:
                                producto1 = nuevoProducto;
                                break;
                            case 2:
                                producto2 = nuevoProducto;
                                break;
                            case 3:
                                producto3 = nuevoProducto;
                                break;
                            case 4:
                                producto4 = nuevoProducto;
                                break;
                        }
                    }
                    if (subtotal >= 1000 && subtotal <= 5000) {
                        descuento = subtotal * 0.05;
                    } else if (subtotal > 5000) {
                        descuento = subtotal * 0.10;
                    }
                    double impuesto = subtotal * 0.07;
                    double totalPagar = subtotal - descuento + impuesto;
                    System.out.println("Subtotal: " + subtotal);
                    System.out.println("Descuento: " + descuento);
                    System.out.println("Impuesto: " + impuesto);
                    System.out.println("Total a pagar: " + totalPagar);
                    efectivoEnCaja += totalPagar;
                    ventasTotales += subtotal;
                    totalVentas += totalPagar;
                    numeroVentas++;
                    System.out.println("Efectivo en caja actualizado: " + efectivoEnCaja);
                    break;
                case 3:
                    if (!cajaAbierta) {
                        System.out.println("Debe abrir la caja primero.");
                        break;
                    }
                    System.out.print("Ingrese el tipo de proveedor (A, B, C): ");
                    char tipoProveedor = lea.next().charAt(0);
                    System.out.print("Ingrese el código del producto a comprar: ");
                    int codigoCompra = lea.nextInt();
                    String productoCompra = "";
                    double precioCompra = 0.0;
                    int inventarioCompra = 0;
                    switch (codigoCompra) {
                        case 1:
                            productoCompra = producto1;
                            break;
                        case 2:
                            productoCompra = producto2;
                            break;
                        case 3:
                            productoCompra = producto3;
                            break;
                        case 4:
                            productoCompra = producto4;
                            break;
                        default:
                            System.out.println("Código de producto no válido.");
                            continue;
                    }
                    int primerDelimCompra = productoCompra.indexOf('|');
                    int segundoDelimCompra = productoCompra.indexOf('|', primerDelimCompra + 1);
                    int tercerDelimCompra = productoCompra.indexOf('|', segundoDelimCompra + 1);
                    int cuartoDelimCompra = productoCompra.indexOf('|', tercerDelimCompra + 1);
                    String nombreCompra = productoCompra.substring(primerDelimCompra + 1, segundoDelimCompra);
                    precioCompra = Double.parseDouble(productoCompra.substring(tercerDelimCompra + 1, cuartoDelimCompra));
                    inventarioCompra = Integer.parseInt(productoCompra.substring(cuartoDelimCompra + 1));
                    boolean puedeComprar = false;
                    switch (tipoProveedor) {
                        case 'A':
                            if (codigoCompra == 1 || codigoCompra == 4) {
                                puedeComprar = true;
                            }
                            break;
                        case 'B':
                            if (codigoCompra == 2 || codigoCompra == 3) {
                                puedeComprar = true;
                            }
                            break;
                        case 'C':
                            if (codigoCompra == 2) {
                                puedeComprar = true;
                            }
                            break;
                    }
                    if (puedeComprar) {
                        System.out.println("Producto: " + nombreCompra);
                        System.out.println("Precio por kg: " + precioCompra);
                        System.out.print("Ingrese la cantidad en kg a comprar: ");
                        double cantidadCompra = lea.nextDouble();
                        double totalCompra = cantidadCompra * precioCompra;
                        if (efectivoEnCaja >= totalCompra) {
                            efectivoEnCaja -= totalCompra;
                            comprasTotales += totalCompra;
                            totalCompras += totalCompra;
                            numeroCompras++;
                            inventarioCompra += cantidadCompra;
                            switch (codigoCompra) {
                                case 1:
                                    totalCompraProd1 += totalCompra;
                                    break;
                                case 2:
                                    totalCompraProd2 += totalCompra;
                                    break;
                                case 3:
                                    totalCompraProd3 += totalCompra;
                                    break;
                                case 4:
                                    totalCompraProd4 += totalCompra;
                                    break;
                            }
                            System.out.println("Compra realizada con éxito.");
                            System.out.println("Efectivo en caja actualizado: " + efectivoEnCaja);
                        } else {
                            System.out.println("No hay suficiente efectivo en caja para realizar la compra.");
                        }
                    } else {
                        System.out.println("NO PUEDE COMPRAR DICHO PRODUCTO.");
                    }
                    String nuevoProductoCompra = productoCompra.substring(0, cuartoDelimCompra + 1) + inventarioCompra;
                    switch (codigoCompra) {
                        case 1:
                            producto1 = nuevoProductoCompra;
                            break;
                        case 2:
                            producto2 = nuevoProductoCompra;
                            break;
                        case 3:
                            producto3 = nuevoProductoCompra;
                            break;
                        case 4:
                            producto4 = nuevoProductoCompra;
                            break;
                    }
                    break;
                case 4:
                    if (!cajaAbierta) {
                        System.out.println("Debe abrir la caja primero.");
                        break;
                    }
                    System.out.println("** Reportes **");
                    System.out.println("Ventas totales: " + ventasTotales);
                    System.out.println("Total ventas: " + totalVentas);
                    System.out.println("Número de ventas: " + numeroVentas);
                    System.out.println("Compras totales: " + comprasTotales);
                    System.out.println("Total compras: " + totalCompras);
                    System.out.println("Número de compras: " + numeroCompras);
                    System.out.println("Efectivo actual en caja: " + efectivoEnCaja);
                    System.out.println("Ranking de productos vendidos:");
                    if (totalVentaProd1 >= totalVentaProd2 && totalVentaProd1 >= totalVentaProd3 && totalVentaProd1 >= totalVentaProd4) {
                        System.out.println("1. " + producto1.split("\\|")[1] + " - Ventas: " + totalVentaProd1);
                        if (totalVentaProd2 >= totalVentaProd3 && totalVentaProd2 >= totalVentaProd4) {
                            System.out.println("2. " + producto2.split("\\|")[1] + " - Ventas: " + totalVentaProd2);
                            if (totalVentaProd3 >= totalVentaProd4) {
                                System.out.println("3. " + producto3.split("\\|")[1] + " - Ventas: " + totalVentaProd3);
                                System.out.println("4. " + producto4.split("\\|")[1] + " - Ventas: " + totalVentaProd4);
                            } else {
                                System.out.println("3. " + producto4.split("\\|")[1] + " - Ventas: " + totalVentaProd4);
                                System.out.println("4. " + producto3.split("\\|")[1] + " - Ventas: " + totalVentaProd3);
                            }
                        } else if (totalVentaProd3 >= totalVentaProd2 && totalVentaProd3 >= totalVentaProd4) {
                            System.out.println("2. " + producto3.split("\\|")[1] + " - Ventas: " + totalVentaProd3);
                            if (totalVentaProd2 >= totalVentaProd4) {
                                System.out.println("3. " + producto2.split("\\|")[1] + " - Ventas: " + totalVentaProd2);
                                System.out.println("4. " + producto4.split("\\|")[1] + " - Ventas: " + totalVentaProd4);
                            } else {
                                System.out.println("3. " + producto4.split("\\|")[1] + " - Ventas: " + totalVentaProd4);
                                System.out.println("4. " + producto2.split("\\|")[1] + " - Ventas: " + totalVentaProd2);
                            }
                        } else {
                            System.out.println("2. " + producto4.split("\\|")[1] + " - Ventas: " + totalVentaProd4);
                            if (totalVentaProd2 >= totalVentaProd3) {
                                System.out.println("3. " + producto2.split("\\|")[1] + " - Ventas: " + totalVentaProd2);
                                System.out.println("4. " + producto3.split("\\|")[1] + " - Ventas: " + totalVentaProd3);
                            } else {
                                System.out.println("3. " + producto3.split("\\|")[1] + " - Ventas: " + totalVentaProd3);
                                System.out.println("4. " + producto2.split("\\|")[1] + " - Ventas: " + totalVentaProd2);
                            }
                        }
                    } else if (totalVentaProd2 >= totalVentaProd1 && totalVentaProd2 >= totalVentaProd3 && totalVentaProd2 >= totalVentaProd4) {
                        System.out.println("1. " + producto2.split("\\|")[1] + " - Ventas: " + totalVentaProd2);
                        if (totalVentaProd1 >= totalVentaProd3 && totalVentaProd1 >= totalVentaProd4) {
                            System.out.println("2. " + producto1.split("\\|")[1] + " - Ventas: " + totalVentaProd1);
                            if (totalVentaProd3 >= totalVentaProd4) {
                                System.out.println("3. " + producto3.split("\\|")[1] + " - Ventas: " + totalVentaProd3);
                                System.out.println("4. " + producto4.split("\\|")[1] + " - Ventas: " + totalVentaProd4);
                            } else {
                                System.out.println("3. " + producto4.split("\\|")[1] + " - Ventas: " + totalVentaProd4);
                                System.out.println("4. " + producto3.split("\\|")[1] + " - Ventas: " + totalVentaProd3);
                            }
                        } else if (totalVentaProd3 >= totalVentaProd1 && totalVentaProd3 >= totalVentaProd4) {
                            System.out.println("2. " + producto3.split("\\|")[1] + " - Ventas: " + totalVentaProd3);
                            if (totalVentaProd1 >= totalVentaProd4) {
                                System.out.println("3. " + producto1.split("\\|")[1] + " - Ventas: " + totalVentaProd1);
                                System.out.println("4. " + producto4.split("\\|")[1] + " - Ventas: " + totalVentaProd4);
                            } else {
                                System.out.println("3. " + producto4.split("\\|")[1] + " - Ventas: " + totalVentaProd4);
                                System.out.println("4. " + producto1.split("\\|")[1] + " - Ventas: " + totalVentaProd1);
                            }
                        } else {
                            System.out.println("2. " + producto4.split("\\|")[1] + " - Ventas: " + totalVentaProd4);
                            if (totalVentaProd1 >= totalVentaProd3) {
                                System.out.println("3. " + producto1.split("\\|")[1] + " - Ventas: " + totalVentaProd1);
                                System.out.println("4. " + producto3.split("\\|")[1] + " - Ventas: " + totalVentaProd3);
                            } else {
                                System.out.println("3. " + producto3.split("\\|")[1] + " - Ventas: " + totalVentaProd3);
                                System.out.println("4. " + producto1.split("\\|")[1] + " - Ventas: " + totalVentaProd1);
                            }
                        }
                    } else if (totalVentaProd3 >= totalVentaProd1 && totalVentaProd3 >= totalVentaProd2 && totalVentaProd3 >= totalVentaProd4) {
                        System.out.println("1. " + producto3.split("\\|")[1] + " - Ventas: " + totalVentaProd3);
                        if (totalVentaProd1 >= totalVentaProd2 && totalVentaProd1 >= totalVentaProd4) {
                            System.out.println("2. " + producto1.split("\\|")[1] + " - Ventas: " + totalVentaProd1);
                            if (totalVentaProd2 >= totalVentaProd4) {
                                System.out.println("3. " + producto2.split("\\|")[1] + " - Ventas: " + totalVentaProd2);
                                System.out.println("4. " + producto4.split("\\|")[1] + " - Ventas: " + totalVentaProd4);
                            } else {
                                System.out.println("3. " + producto4.split("\\|")[1] + " - Ventas: " + totalVentaProd4);
                                System.out.println("4. " + producto2.split("\\|")[1] + " - Ventas: " + totalVentaProd2);
                            }
                        } else if (totalVentaProd2 >= totalVentaProd1 && totalVentaProd2 >= totalVentaProd4) {
                            System.out.println("2. " + producto2.split("\\|")[1] + " - Ventas: " + totalVentaProd2);
                            if (totalVentaProd1 >= totalVentaProd4) {
                                System.out.println("3. " + producto1.split("\\|")[1] + " - Ventas: " + totalVentaProd1);
                                System.out.println("4. " + producto4.split("\\|")[1] + " - Ventas: " + totalVentaProd4);
                            } else {
                                System.out.println("3. " + producto4.split("\\|")[1] + " - Ventas: " + totalVentaProd4);
                                System.out.println("4. " + producto1.split("\\|")[1] + " - Ventas: " + totalVentaProd1);
                            }
                        } else {
                            System.out.println("2. " + producto4.split("\\|")[1] + " - Ventas: " + totalVentaProd4);
                            if (totalVentaProd1 >= totalVentaProd2) {
                                System.out.println("3. " + producto1.split("\\|")[1] + " - Ventas: " + totalVentaProd1);
                                System.out.println("4. " + producto2.split("\\|")[1] + " - Ventas: " + totalVentaProd2);
                            } else {
                                System.out.println("3. " + producto2.split("\\|")[1] + " - Ventas: " + totalVentaProd2);
                                System.out.println("4. " + producto1.split("\\|")[1] + " - Ventas: " + totalVentaProd1);
                            }
                        }
                    } else {
                        System.out.println("1. " + producto4.split("\\|")[1] + " - Ventas: " + totalVentaProd4);
                        if (totalVentaProd1 >= totalVentaProd2 && totalVentaProd1 >= totalVentaProd3) {
                            System.out.println("2. " + producto1.split("\\|")[1] + " - Ventas: " + totalVentaProd1);
                            if (totalVentaProd2 >= totalVentaProd3) {
                                System.out.println("3. " + producto2.split("\\|")[1] + " - Ventas: " + totalVentaProd2);
                                System.out.println("4. " + producto3.split("\\|")[1] + " - Ventas: " + totalVentaProd3);
                            } else {
                                System.out.println("3. " + producto3.split("\\|")[1] + " - Ventas: " + totalVentaProd3);
                                System.out.println("4. " + producto2.split("\\|")[1] + " - Ventas: " + totalVentaProd2);
                            }
                        } else if (totalVentaProd2 >= totalVentaProd1 && totalVentaProd2 >= totalVentaProd3) {
                            System.out.println("2. " + producto2.split("\\|")[1] + " - Ventas: " + totalVentaProd2);
                            if (totalVentaProd1 >= totalVentaProd3) {
                                System.out.println("3. " + producto1.split("\\|")[1] + " - Ventas: " + totalVentaProd1);
                                System.out.println("4. " + producto3.split("\\|")[1] + " - Ventas: " + totalVentaProd3);
                            } else {
                                System.out.println("3. " + producto3.split("\\|")[1] + " - Ventas: " + totalVentaProd3);
                                System.out.println("4. " + producto1.split("\\|")[1] + " - Ventas: " + totalVentaProd1);
                            }
                        } else {
                            System.out.println("2. " + producto3.split("\\|")[1] + " - Ventas: " + totalVentaProd3);
                            if (totalVentaProd1 >= totalVentaProd2) {
                                System.out.println("3. " + producto1.split("\\|")[1] + " - Ventas: " + totalVentaProd1);
                                System.out.println("4. " + producto2.split("\\|")[1] + " - Ventas: " + totalVentaProd2);
                            } else {
                                System.out.println("3. " + producto2.split("\\|")[1] + " - Ventas: " + totalVentaProd2);
                                System.out.println("4. " + producto1.split("\\|")[1] + " - Ventas: " + totalVentaProd1);
                            }
                        }
                    }
                    break;
                case 5:
                    cajaAbierta = false;
                    System.out.println("Caja cerrada. Efectivo en caja: " + efectivoEnCaja);
                    break;
                case 6:
                    sistemaActivo = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}

       
    
