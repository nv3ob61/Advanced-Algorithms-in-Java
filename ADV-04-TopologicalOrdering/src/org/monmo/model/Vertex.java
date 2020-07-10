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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nv3ob61
 */
public class Vertex {

  private String name;
  private boolean visited;
  private List<Vertex> neighbourList;

  public Vertex(String name) {
    this.name = name;
    this.neighbourList = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public boolean isVisited() {
    return visited;
  }

  public List<Vertex> getNeighbourList() {
    return neighbourList;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public void setNeighbourList(List<Vertex> neighbourList) {
    this.neighbourList = neighbourList;
  }

  public void addNeighbour(Vertex v){
    this.neighbourList.add(v);
  }

  @Override
  public String toString() {
    return "" + this.getName();
  }

}
