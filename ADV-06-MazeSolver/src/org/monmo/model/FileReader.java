/* 
 * Copyright (C) 2020 mon_mode   0mon.mode@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.monmo.model;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author nv3ob61
 */
public class FileReader {

  private int[][] map;
  private String fileName;
  private int rows;
  private int cols;
  private int startCol;  //start index of the 2 start point colIndex
  private int startRow;  //start index of the 2 start point rowIndex

  public FileReader(String fileName, int rows, int cols) {

    this.fileName = fileName;
    this.rows = rows;
    this.cols = cols;
    this.map = new int[rows][cols];
  }

  public void parseFile() {
    try {
      Scanner sc = new Scanner(new File(this.fileName));

      for (int i = 0; i < this.rows; i++) {
        for (int j = 0; j < this.cols; j++) {

          map[i][j] = sc.nextInt();  //read integers from the file

          if (map[i][j] == 2) {
            startCol = j;
            startRow = i;
          }
        }
      }
      sc.close();
    } catch (Exception e) {
      System.out.println("OOOOPS! - fallo lectura");

    }
  }

  public int getStartPositionCol() {
    return startCol;
  }

  public int getStartPositionRow() {
    return startRow;
  }
  
  public int [][] getMap(){
    return this.map;
  }

}
