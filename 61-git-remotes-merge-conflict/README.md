# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
 /mnt/c/Users/p/De/O/lab06-01  git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test
Cloning into 'OOP-git-merge-conflict-test'...
remote: Enumerating objects: 12, done.
remote: Counting objects: 100% (4/4), done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 12 (delta 1), reused 1 (delta 1), pack-reused 8 (from 1)
Receiving objects: 100% (12/12), done.
Resolving deltas: 100% (2/2), done.
2. Ci si assicuri di avere localmente entrambi i branch remoti
3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`
Auto-merging HelloWorld.java
CONFLICT (content): Merge conflict in HelloWorld.java
Automatic merge failed; fix conflicts and then commit the result.
4. Si noti che viene generato un **merge conflict**!
On branch master
Your branch is up to date with 'origin/master'.

You have unmerged paths.
  (fix conflicts and run "git commit")
  (use "git merge --abort" to abort the merge)

Unmerged paths:
  (use "git add <file>..." to mark resolution)
        both modified:   HelloWorld.java

no changes added to commit (use "git add" and/or "git commit -a")
5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  feature  git merge master
Auto-merging HelloWorld.java
CONFLICT (content): Merge conflict in HelloWorld.java
Automatic merge failed; fix conflicts and then commit the result.
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  feature merge ~1  git status                               1 ✘  15:14:20
On branch feature
Your branch is up to date with 'origin/feature'.

You have unmerged paths.
  (fix conflicts and run "git commit")
  (use "git merge --abort" to abort the merge)

Unmerged paths:
  (use "git add <file>..." to mark resolution)
        both modified:   HelloWorld.java

no changes added to commit (use "git add" and/or "git commit -a")
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  feature merge ~1  code HelloWorld.java                       ✔  15:14:31
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  feature merge ~1  git log -all -graph -oneline               ✔  15:14:51
error: switch `l' expects a numerical value
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  feature merge ~1  git log --graph                        HUP ✘  15:15:41
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  feature merge ~1  git add HelloWorld.java              ✔  14s  15:16:02
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  feature merge +1  git commit -m "Changed the HelloWorld.java file"
[feature 2b967a3] Changed the HelloWorld.java file
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  feature ⇡2 
git status                                       ✔  15:16:29
On branch feature
Your branch is ahead of 'origin/feature' by 2 commits.
  (use "git push" to publish your local commits)

nothing to commit, working tree clean
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  feature ⇡2 
git log --graph --all                            ✔  15:16:38

 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  feature ⇡2    
6. Si crei un nuovo repository nel proprio github personale
7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  feature ⇡2  git remote add mygithubrepo https://github.com/pebdock/lab06-1.git
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  feature ⇡2  git remote -v        ✔  15:20:44
mygithubrepo    https://github.com/pebdock/lab06-1.git (fetch)
mygithubrepo    https://github.com/pebdock/lab06-1.git (push)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test (fetch)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test (push)
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  feature ⇡2     
8. Si faccia push del branch `master` sul proprio repository
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  master ⇡2  git push git@github.com:pebdock/lab06-1.git
The authenticity of host 'github.com (140.82.121.3)' can't be established.
ED25519 key fingerprint is SHA256:+DiY3wvvV6TuJJhbpZisF/zLDA0zPMSvHdkr4UvCOqU.
This key is not known by any other names.
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
Warning: Permanently added 'github.com' (ED25519) to the list of known hosts.
Enumerating objects: 15, done.
Counting objects: 100% (15/15), done.
Delta compression using up to 16 threads
Compressing objects: 100% (11/11), done.
Writing objects: 100% (15/15), 1.57 KiB | 178.00 KiB/s, done.
Total 15 (delta 4), reused 10 (delta 2), pack-reused 0
remote: Resolving deltas: 100% (4/4), done.
To github.com:pebdock/lab06-1.git
 * [new branch]      master -> master
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  master ⇡2      

9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  master ⇡2  git push -set-upstream mygithubrepo master
error: did you mean `--set-upstream` (with two dashes)?
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  master ⇡2  git push --set-upstream mygithubrepo master
Username for 'https://github.com': pebdock
Password for 'https://pebdock@github.com':
remote: Invalid username or token. Password authentication is not supported for Git operations.
fatal: Authentication failed for 'https://github.com/pebdock/lab06-1.git/'
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  master ⇡2  git remote -v                        mygithubrepo    https://github.com/pebdock/lab06-1.git (fetch)
mygithubrepo    https://github.com/pebdock/lab06-1.git (push)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test (fetch)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test (push)
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  master ⇡2  git remote add mygithubrepo git@github.com:pebdock/lab06-1.git
error: remote mygithubrepo already exists.
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  master ⇡2  git remote remove mygithubrepo
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  master ⇡2  git remote add mygithubrepo git@github.com:pebdock/lab06-1.git
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  master ⇡2  git push --set-upstream mygithubrepo master
branch 'master' set up to track 'mygithubrepo/master'.
Everything up-to-date
 /mnt/c/Users/p/De/O/OOP-git-merge-conflict-test  master                           ✔  15:47:20

