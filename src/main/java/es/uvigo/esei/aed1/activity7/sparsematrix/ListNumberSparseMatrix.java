package es.uvigo.esei.aed1.activity7.sparsematrix;

import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;
import java.util.Iterator;

public class ListNumberSparseMatrix implements NumberSparseMatrix {

  private final int numRows;
  private final int numCols;
  private final List<ValueRow> rows;

  public ListNumberSparseMatrix(int n, int m) throws IllegalArgumentException {
    if (n <= 0 || m <= 0) {
      throw new IllegalArgumentException();
    }
    this.numRows = n;
    this.numCols = m;
    rows = new LinkedList<>();
  }

  @Override
  public int getNumRows() {
    return this.numRows;
  }

  @Override
  public int getNumCols() {
    return this.numCols;
  }

  @Override
  public Number get(int i, int j) throws IndexOutOfBoundsException {

    if (i <= 0 || i > numRows || j <= 0 || j > numCols) {
      throw new IndexOutOfBoundsException("Out of Bound");
    }

    for (ValueRow rowData : rows) {
      if (rowData.getRow() == i) {

        for (ValueCol colData : rowData.getColumns()) {
          if (colData.getColumn() == j) {
            return colData.getValue();
          }
        }

      }

      return 0;
    }

    return 0;
  }

  @Override
  public void set(int i, int j, Number value) throws IndexOutOfBoundsException {
    if (i <= 0 || i > numRows || j <= 0 || j > numCols) {
      throw new IndexOutOfBoundsException("Out of Bound");
    }

    
  

  ValueRow targetRow = null;


  // 2. Buscamos si la fila ya existe
  for(ValueRow r:rows) {
    if (r.getRow() == i) {
      targetRow = r;
      break;
    }
  }

  // 3. Si la fila no existe y el valor no es cero, la creamos
  if(targetRow==null){
    if (value.doubleValue() != 0) {
      targetRow = new ValueRow(i);
      rows.addLast(targetRow); // Añadimos la nueva fila a la lista de filas
      targetRow.getColumns().addLast(new ValueCol(j, value));
    }
    return; // Si el valor era 0 y no había fila, terminamos.
  }

  // 4. Si la fila sí existe, buscamos la columna
  ValueCol targetCol = null;
  for(ValueCol c : targetRow.getColumns())
  {
    if (c.getColumn() == j) {
      targetCol = c;
      break;
    }
  }

  if(targetCol!=null)
  {
    // Si la columna existe, actualizamos el valor
    targetCol.setValue(value);
    // Opcional: Si el valor ahora es 0, podrías eliminar el nodo ValueCol aquí
  }else{
    // Si la columna no existe y el valor no es cero, la creamos
    if (value.doubleValue() != 0) {
      targetRow.getColumns().addLast(new ValueCol(j, value));
    }
  }

}
