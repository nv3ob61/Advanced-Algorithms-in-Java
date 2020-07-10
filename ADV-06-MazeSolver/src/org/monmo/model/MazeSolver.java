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

/**
 *
 * @author nv3ob61
 */
public class MazeSolver {

  private int[][] mazeMap;
  private boolean[][] visited;
  private int startCol;
  private int startRow;

  public MazeSolver(int[][] mazeMap, int startRow, int startCol) {
    this.visited = new boolean[mazeMap.length][mazeMap.length];
    this.mazeMap = mazeMap;
    this.startCol = startCol;
    this.startRow = startRow;
  }

  public void findWayOut() {
    try {
      dfs(startRow, startCol);
      System.out.println("No solution found...");
    } catch (Exception e) {
      System.out.println("Olé! - Route found to exit.");

    }
  }

  private void dfs(int rowIndex, int colIndex) {

    System.out.println("Visiting i=" + rowIndex + ", j=" + colIndex);
    if (this.mazeMap[rowIndex][colIndex] == 3) {
      throw new RuntimeException();
    }

    int endOfMap = this.mazeMap.length - 1;

    if (visited[rowIndex][colIndex]) {
      return;
    } else if (rowIndex < 0 || rowIndex >= endOfMap) {
      return;
    } else if (colIndex < 0 || colIndex >= endOfMap) {
      return;
    } else if (this.mazeMap[rowIndex][colIndex] == 1) {
      return;
    } else {
      this.visited[rowIndex][colIndex] = true;

      dfs(rowIndex + 1, colIndex);  //down
      dfs(rowIndex, colIndex + 1);  //right
      dfs(rowIndex, colIndex - 1);  //left
      dfs(rowIndex - 1, colIndex);  //up
    }
  }
}
