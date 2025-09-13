
# Cloud-based User File Management System

This is a Java desktop project for managing user files both locally and in AWS S3. The application is intended to be opened and run from NetBeans or a similar Java IDE. It is not distributed as a standalone executable.

## Features

- **Offline mode:** All operations use a local SQLite database; no network required.
- **Online mode:** Optional AWS integration (S3 for file storage, RDS for metadata).
- **File upload/download via file chooser:** Users select files using the standard file selection dialog (drag-and-drop is not supported).
- **User authentication:** Username/password stored in RDS/SQLite.
- **Simple UI:** Built with Java Swing.
- **Session management for users and admins.**

## Project Structure

```
src/
  Admin/
    ConnectionManager.java
    Login.form
    Login.java
    MainPage.form
    MainPage.java
    sessionclass.java
  User/
    App.java
    ConnectionManager.java
    Login.form
    Login.java
    MainPage.form
    MainPage.java
    register.form
    register.java
    sessionclass.java
libraries/
  (All required JARs go here)
dbs.sql
```

## Prerequisites

| Item                | Version / Notes                        |
|---------------------|----------------------------------------|
| JDK                 | 11 or higher                           |
| NetBeans IDE        | 12+ (or similar Java IDE)              |
| AWS SDK for Java    | 2.x (included in `libraries/`)         |
| SQLite JDBC driver  | 3.36.0+ (included in `libraries/`)     |
| MySQL Connector/J   | 8.0.x (included in `libraries/`)       |
| Additional JARs     | See `libraries/` folder                |
| HeidiSQL            | Optional, for inspecting SQLite DB     |


**Note:**
- HeidiSQL is not required to run the app; it is used for database inspection and management.
- If `rt.jar` is split into multiple parts due to file size limits, see the instructions below for recombining.

### If rt.jar is split into parts

If you receive `rt.jar` as multiple parts (e.g., `rt.zip.001`, `rt.zip.002`, etc.):

1. Download all `rt.zip.001`, `rt.zip.002`, ... files to the same folder.
2. Right-click the first part (`rt.zip.001`) and select **Extract here** using WinRAR, 7-Zip, or a similar tool.
3. The tool will automatically combine the parts and extract the original `rt.jar` file.

On Linux/macOS, you can also use the `cat` command to join parts (if split with `split`):

```bash
cat rt.zip.* > rt.zip
unzip rt.zip
```

Then place the extracted `rt.jar` into the `libraries/` directory.

## Setup

1. **Import the project**
   - In NetBeans: `File → Open Project → select the folder containing the project source`

2. **Add library JARs**
   - Right-click the project → Properties → Libraries → Add JAR/Folder.
   - Browse to the `libraries/` directory and add all JAR files.

3. **Configure offline database**
   - The SQLite file (e.g., `user_files.db`) is created automatically on first run.

4. **Configure online (AWS) integration (optional)**
   - Open the AWS config file (e.g., `AWSConfig.java`).
   - Paste your AWS credentials and bucket name in the designated section.
   - Ensure your IAM user has `s3:PutObject`, `s3:GetObject`, and `rds:*` permissions.

5. **Configure RDS connection (if using online mode)**
   - Set the JDBC URL, username, and password for your RDS instance in the DB config file.

6. **Run the application**
   - Press F6 (Run) in NetBeans.
   - The login screen appears; you can create a new user or log in with an existing one.

## Usage

| Action         | Offline Mode                                              | Online Mode                                              |
|----------------|----------------------------------------------------------|----------------------------------------------------------|
| Upload file    | Saves to local `uploads/` folder, metadata in SQLite.    | Uploads to S3, metadata in RDS; keeps a local copy.      |
| Download file  | Retrieves from local folder.                             | Downloads from S3 (or local cache if present).           |
| Delete file    | Removes local copy and SQLite entry.                     | Deletes from S3 and RDS entry.                           |
| Sync           | Not applicable.                                          | Click Sync to push pending local changes to the cloud.    |

## Notes

- This is not a packaged application; you must run it from NetBeans or a similar IDE.
- All required libraries are in the `libraries/` folder (add them to your classpath).
- For production, consider using Maven or Gradle for dependency management.
- The app works fully offline; AWS integration is optional.

## License

This project is licensed under the MIT License.
