package com.example.reports;

/**
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - Viewer depends directly on concrete ReportFile
 * - No Proxy involved
 * Fixed changed to depend on Report interface
 */
public class ReportViewer {

    public void open(Report report, User user) {
        report.display(user);
    }
}
