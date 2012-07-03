package book.hibernate;

import java.util.ArrayList;
import java.util.List;

import book.entities.Section;

public interface SectionHibInterface{
	
	/**
	 * 
	 * @param id id of the desired section
	 * @return The sections specified by the id
	 */
	public Section getSection(Integer id);
	/**
	 * 
	 * @return A list of all the sections 
	 */
	public List<Section> getAllSections();
	/**
	 * 
	 * @param section a given node 
	 * @return A list of all the nodes that have the given section as its parent
	 */
	public List<Section> getChildren(Section section);
	/**
	 * 
	 * @param section a given node
	 * @return returns the parent node
	 */
	public Section getPareent(Section section);
	
	
}



