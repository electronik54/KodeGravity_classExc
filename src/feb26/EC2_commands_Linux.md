# OS Amazon Linux 2023 AMI 2023.10.20260202.2 x86_64 HVM kernel-6.1
***
***
## File system navigation commands
- `pwd` : shows your current directory
- `ls` : lists files in the current directory
- `ls -l` : long listing (permissions, size, owner)
- `ls -a` : shows hidden files
- `cd <foldername>` : move into a folder
- `cd ..` : go up one level
- `cd /path/to/folder` : go to an absolute path
- `cd` : go to your home directory
- `cat <fileName.ext>` : check the content of a file
- `touch <fileName.ext>` : creates a file

## VIM EDITOR
#### (1) *Open Editor*
  - `vim <fileName.ext>`	- to open file with vim

#### (2) *Normal mode — moving around, deleting, copying, saving*
  - `x` : Delete a character
  - `dd` : Delete a whole line
  - `yy` : Copy (yank) a line
  - `p` : Paste

#### (3) *Insert mode — typing text normally*
  - `i` : This puts you in Insert mode. to insert text in file. you will see  `--INSERT--` at the bottom

    ##### *(3.1)Saving and quitting*
    + `Esc` : Now you’re back in Normal mode.
      + `:w` : Save 
      + `:q` : Quit Vim
      + `:wq`
      + `:q!`:Quit without saving

## PERMISSIONS 
Type `ls -l` and you will see `-rw-r--r-- 1 ec2-user ec2-user  120 Mar 5 <fileName.ext>`[^1]:
> - `-rw-r--r--` → permissions
> - `ec2-user` → owner
> - `ec2-user` → group
> - `rw- r-- r--`\
>`|...|...|`\
>`|...|...└── others`\
>`|...└────── group`\
>`└────────── owner`

`chmod`		- to change permission *EXAMPLE*: `chmod 644 <fileName.ext>`

## BASH SCRIPT
A shebang line at the top of the file so Linux knows to use Bash. This is the first line of the script and looks like `#!/bin/bash`
- Linux documentation emphasizes that this line must be the very first line for the script to run correctly .
- The script must be executable, meaning it has the x (execute) permission.
Shell scripts only run directly when they have the proper execution permissions.

example script to print "Hello from my EC2 instance!"
```
#!/bin/bash`\
echo "Hello from my EC2 instance!"
```

example script to print "Hello from my EC2 instance!"
> `#!/bin/bash`\
> `echo "Hello from my EC2 instance!"`

RUN THE SCRIPT
Type `./<fileName.sh>` in console *(needs `execute` permission)*[^1]\
**OR**
`bash script.sh` *(DOES NOT needs `execute` permission)*