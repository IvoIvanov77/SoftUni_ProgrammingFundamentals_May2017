package exam_preparation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Files {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<File> files = new ArrayList<>();
		int n = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < n; i++) {
			File file = new File(sc.nextLine());			
			if(files.contains(file)){
				files.get(files.indexOf(file)).size = file.size;
			}else{
				files.add(file);
			}			
		}
		String[] filter = sc.nextLine().split(" ");
		String extension = filter[0];
		String root = filter[filter.length - 1];
		Collections.sort(files);
		boolean hasSuchFiles = false;
		for (File f : files) {
			if(f.name.endsWith(extension) && f.root.equals(root)){
				System.out.printf("%s - %d KB%n", f.name,  f.size);
				hasSuchFiles = true;
			}
		}
		
		if(!hasSuchFiles){		
			System.out.println("No");
		}

	}

}

class File implements Comparable<File>{
	String name;	
	String root;
	BigInteger size;
	
//	D:\Documents\02. Documents\ presentation.pptx;44234
	public File(String path) {
		super();
		String[] directories = path.split("[\\\\]+");
		String[] fileAndSize = directories[directories.length - 1].split(";");		
		this.name = fileAndSize[0];		
		this.root = directories[0];
		this.size = new BigInteger(fileAndSize[fileAndSize.length - 1]);
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;		
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((root == null) ? 0 : root.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		File other = (File) obj;		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (root == null) {
			if (other.root != null)
				return false;
		} else if (!root.equals(other.root))
			return false;
		return true;
	}



	


	@Override
	public int compareTo(File other) {
		int n = other.size.compareTo(this.size);		
		return n == 0 ? this.name.compareTo(other.name) : n;
	}
	
	
	
	
}
