# BRANCHING STRATEGIES
1. `git checkout -b <feature_branch_name>` will create a new branch called feature_branch_name and switch to it

# KEY TAKEAWAY
1. Branches exist locally first. They only exist on GitHub after you push them. So if you create a branch and commit on it, GitHub has no idea until you push. After push every branch exists locally and remotely.
```tree
EXAMPLE
  - Local branches:
    - main
    - feature_branch_name
  - Remote branches (on GitHub)
    - origin/main
    - origin/feature_branch_name (only exists after you push it)
```
2. When you commit on a branch, you are only updating the local version of that branch. GitHub doesn’t know anything changed **UNTIL YOU PUSH**.
   - Only when you do `git push -u origin feature_branch_name`, now **GITHUB** creates ` origin/feature_branch_name` and your commits appear online.
3. Commands that affect ONLY the GIT:
   - `git add`
   - `git commit`
   - `git branch`
   - `git checkout / git switch`
   - `git merge (local merge)`
   - `git log`
4. Commands that affect the GITHUB (or online repo):
   - `git push` (upload your commits)
   - `git pull` (download commits from GitHub)
   - `git fetch` (check for updates without merging)

# BRANCHING STRATEGIES(cont...)
2. when you do `git checkout -b <feature_branch_name>`, `main` and `<feature_branch_name>` are identical until you start making new commits on the new branch. 
   - now you are on `<feature_branch_name>` branch
   - After creating the branch, you do your work on `<feature_branch_name>` branch. This means all your `git add`, `git commit`, all your changes affect only `<feature_branch_name>` branch, not main. This keeps main clean and stable.
   ```
   EXAMPLE
   Imagine this sequence:
   - You are on main
   - You create a branch with `git checkout -b <feature_branch_name>`
   - You make 3 commits on `<feature_branch_name>`
   - You switch back to main
   - `main` looks EXACTLY the same as before you created the branch
   - HENCE: A branch only contains the commits made on that branch. `main` stays untouched until you merge something into it.
    ```
3. Once you’ve made your commits locally, the next step is push the branch to GitHub, this makes the BRANCH visible online. you do `git push -u origin <feature_branch_name>` _(or `git push` if you have already pushed before)_ which does two things:
   - Uploads your branch to GitHub
   - Links your local branch to the remote one








***

### *QUERY for copilot*
```azure
- i have a free GitHub account and i have never collaborated with anyone before. I have some repos on my GitHub but i am the only one who has committed to it and i always use the master/main branch. I know add, commit, push and pull commands but i have no idea how they work when branching is involved, especially when branches are involved. Teach me branching strategies
- when i run git commit, it only affects the local GIT and not the GitHub right? I am very confused about what does the command affects, weather its local git for the GitHub too and this is why i am confused about the branching as well
```