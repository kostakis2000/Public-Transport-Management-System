# Public Transport Management System — team work split

The Android application is in `android-app/`. Member 1 is the lead and has set up the Android app, shared models, and initial repository. These starter screens belong to members 2–6. Each person should implement only their assigned Kotlin activity and matching XML layout so the work stays separate.

| Member | Feature | Kotlin file | Layout file |
|---|---|---|---|
| 2 | Find and view routes | `android-app/app/src/main/java/com/example/publictransport/ui/routesearch/RouteSearchActivity.kt` | `android-app/app/src/main/res/layout/activity_routesearch.xml` |
| 3 | Book a ticket | `android-app/app/src/main/java/com/example/publictransport/ui/booking/BookingActivity.kt` | `android-app/app/src/main/res/layout/activity_booking.xml` |
| 4 | View transport schedules | `android-app/app/src/main/java/com/example/publictransport/ui/schedule/ScheduleActivity.kt` | `android-app/app/src/main/res/layout/activity_schedule.xml` |
| 5 | Manage fleet/vehicles | `android-app/app/src/main/java/com/example/publictransport/ui/fleet/FleetManagementActivity.kt` | `android-app/app/src/main/res/layout/activity_fleet.xml` |
| 6 | View reports | `android-app/app/src/main/java/com/example/publictransport/ui/reports/ReportsActivity.kt` | `android-app/app/src/main/res/layout/activity_reports.xml` |

## Each member's Git steps

1. Get the latest `master` in Android Studio using **Git > Pull** (or `git pull origin master`).
2. Create a personal branch, for example `git switch -c feature/route-search`.
3. Open only your assigned Kotlin and XML files, replace the TODO starter UI with your implementation, and save.
4. Commit only your two files: `git add <your Kotlin file> <your XML file>` then `git commit -m "Implement <feature> screen"`.
5. Push your branch: `git push -u origin <your-branch-name>`.
6. Open a Pull Request into `master` and ask Member 1 to review/integrate it. If you have direct write permission and the lecturer requires direct pushes, coordinate first and push your feature branch, not concurrent unreviewed changes to `master`.

Do not edit `MainActivity.kt`, the manifest, Gradle files, or shared model/repository files without coordinating with Member 1; those are integration points. Member 1 will connect the completed screens from the main screen and register them in the manifest after the feature branches are ready.
