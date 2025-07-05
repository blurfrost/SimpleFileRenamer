SimpleFileRenamer

A simple script that renames files in a specified directory to your own specification.

How to use:
1. Ensure you have Java installed.
2. Move the directory that contains the files you want to rename into the directory containing this script. (You may also specify the relative path your files are in to this script's directory when the program is ran if you do not wish to move the files)
3. In your terminal, navigate to the directory containing this script and run: java Renamer
4. You will be prompted: "Specify Directory Name". If the files exist in a folder in this directory, simply state the name of the directory. Else, you may state the relative path your files are in to this script's directory.
5. You will be prompted: "Renaming contents of folder [your folder], input Y to confirm:". Input Y to continue. Else, any other input will close the program.
6. You will be prompted: "Only rename files of a certain name? If yes, specify substring. If no, leave blank (press ENTER)". If you wish to rename files only of a certain file name, specify it. Else, you may leave this input blank (all files in the given directory will be renamed)
7. You will be prompted: "Append anything to the start of the new filename?". Input any substring you wish to append to the front of the filename. Include any blank spaces if you wish to do so.
8. The program will rename all files in the directory that satisfy the filename conditions.
