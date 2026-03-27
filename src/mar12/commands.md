- ### GitHub is just a remote copy of your repository.
  - It only changes when you push or pull.**

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
   - `git merge (local merge)` - REMEMBER: Merging copies commits — it doesn’t link branches forever
   - `git log`
   - `git branch` list all branches. The one with the `*` is your current branch.
   - `git status` check your current branch
   
4. Commands that affect the GITHUB (or online repo):
   - `git push` sends/upload your commits and only pushes the branch you are currently on. If you want to push a different branch, you must switch to it first
   - `git pull` brings/download commits from GitHub for the branch that you are on (also refer _(*-u)_)
   - `git fetch` (check for updates without merging)

# WHAT MERGING REALLY DOES
5. Merging combines two branches into one by creating a new commit that has two parents.
   ```
   main:    A --- B --- C
                    \
   feature:          D --- E
   ```
   - When you merge feature into main, Git creates:
   ```
   main:    A --- B --- C --------- M
                    \             /
   feature:          D --- E ----
   ```
   - `M` is the merge commit.

# REBASING
- Rebasing rewrites history by moving your commits to a new base.
  - example
     ```
     main:    A --- B --- C
                     \
     feature:        D --- E
     ```
    - If you run `git rebase main`, Git takes your commits `D` and `E`, copies them, and places them on top of `C`:
     ```
      main:    A --- B --- C
                              \
      feature:                  D' --- E'
     ```
    - Why some developers love rebase
      - The history looks cleaner
      - No merge commits
      - Easier to read when reviewing logs
      - Makes git log and git bisect simpler
    > “Rebase your own branches. Never rebase shared branches.”





   

# BRANCHING STRATEGIES(cont...)
5. When you do `git checkout -b <feature_branch_name>`, `main` and `<feature_branch_name>` are identical until you start making new commits on the new branch. 
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
6. Once you’ve made your commits locally, the next step is push the branch to GitHub, this makes the BRANCH visible online. you do `git push -u origin <feature_branch_name>` _(or `git push` if you have already pushed before)_ which does two things:
   - Uploads your branch to GitHub
   - Links your local branch to the remote one
   - _(*-u)_ `-u` (upstream) tells Git This local branch corresponds to that remote branch. After that, you can simply run `git push` or `git pull` and Git knows which remote branch to sync with


7. What if main changes while you’re still working on your feature branch
   ```
   main:            A --- B --- C
   feature-login:   A --- D --- E
   ```
   - If you want your feature branch to include the new commit C, you can run: `git checkout feature-login` > `git merge main`. This updates your feature branch with the latest changes from `main`.

# STASH
   - Imagine you’re on feature-login and you changed `index.js`. Then you try to switch to main, but main has a different version of `index.js`. If Git allowed the switch, your changes might get overwritten. So Git says:
   >“You have uncommitted changes. I won’t switch branches until you save them.”
   - `git stash` temporarily hides your changes so you can switch branches safely.
      ```
     FOR EXAMPLE
      git stash
      git checkout main
      ```
     - Your changes are saved but not visible. When you want them back use `git stash pop`

# KEY TAKEAWAY
   - GitHub only changes when you push or pull. So when you create a branch locally with `git checkout -b feature-xyz`, GitHub knows nothing about it.
   - When you push with `git push -u origin feature-xyz`, GitHub creates a matching branch.
   - From then on `git push` updates the branch on GitHub AND `git pull` brings changes from GitHub into your local branch

# Merge on GitHub vs. Locally (NEED MORE)
- Merging can happen in two places, (1)Locally (on your computer), (2)Remotely (on GitHub) and both do the same thing, they take the commits from your `feature branch` and add them to `main`.
- If you merge on **GitHub**, it updates the remote>`main`, your local>`main` does not update automatically. You must run `git pull` while on `main` to sync your computer with GitHub

# The Pull Request
- A Pull Request (PR) is how you propose changes and invite others to review them. A PR is not just a merge button. It’s a conversation space where you can show what you changed, explain why you changed it, get feedback, discuss alternatives, run automated tests, merge safely into `main`
  - A typical team workflow looks like this **>** everyone `pulls` the latest `main` **>** Each person creates their own `feature branch` **>**  They `commit` and `push` their work **>** They open a Pull Request **>** Teammates review the PR **>** The PR gets `merged` into `main` **>** The `feature branch` is deleted
    - ### Key Idea
      1. Update your feature branch
         - Option 1: Merge main into your branch
            ```
            git checkout feature-xyz
            git merge main
            ```
         - Option 2: Rebase your branch onto main
            ```
            git checkout feature-xyz
            git rebase main
            ```
      2. Resolve merge conflict 
         - Keep the version from `head` 
         **OR**
         - Keep the version from your `feature branch` 
         **OR**
         - Combine them
         - A merge conflict can happen in multiple files at once, and you resolve each file one at a time. This means Git stopped the merge, it marked each file with conflict markers, you must open each file and fix it manually then `git add .` and `git commit` to merge
         - Git won’t let you complete the merge until every conflict is resolved.













