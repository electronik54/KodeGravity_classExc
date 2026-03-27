# KEYWORDS IN GIT
1. `GIT` : its installed on you local computer to track the files on your system
2. `GITHUB` : it's the online repository management system where you can store your code
3. `commit` :  it tells git that this is the final version of my file for now. It also lets you add some comments to the commit where you can mention something about the commit but this does add the tracking the file yet
4. `push` : it tells GIT that the committed files are needed 
5. `init` : its tells GIT that you want to track the content of this folder

---

# INITIALIZE THE LOCAL FOLDER FOR GIT TRACKING
1. `git -v \ git --version` - to get installed version of git OR to check if git is installed 
2. `git init` - to initialize a project folder on local
3. `git status` - to check the status of the project folder
4. `git add .` - to start tracking all the items in the directory
5. `git commit -m "<your_message>"` - to commit to local git repo. If you add -m then type your message in `"<your_message>"`
6. OPTIONAL: type `git status` to check if files are locally committed
7. AT THIS POINT YOU HAVE LOCAL GIT REPO READY AND COMMITTED

---

# INITIALIZE NEW GITHUB REPOSITORY
1. GO TO GITHUB AND CREATE A NEW REPOSITORY AND COPY ITS LINK that ends with .git 
2. `git remote add origin <your_repository_link.git>` this tells git "My repo is at GitHub and I will call it origin"
3. At this point, if this is you first time to push the code, the GIT will ask you to login into the Github
4. `git push -u origin master` this will push your code to the repository, to the master branch by default so next time you just have to type `git push` to push the code to GitHub to its master branch

> resolve conflicts if any, then:
> git push --force-with-lease
Use --force-with-lease instead of --force to avoid accidentally overwriting others’ work.


---

# KEYTAKE AWAYS
1. `Commit` = make a version locally
2. `Push` = upload to GitHub
3. `Pull` = download from GitHub
