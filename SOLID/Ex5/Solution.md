How I solved the issues:
The main issue was there was no contract established in the parent export class, also subclasses like PdfExporter impose there own tightened preconditions, and each subclass had its own way of handling null. Also PdfExporter throwed exception that caused unexpected behaviour not defined in parent class.

To solve all this:
First I modified ExportResult to include error message so we can return error instead of throwing exception
Then I added:
- isValid() to check for errors (not abstract to allow default)
- getNormalisedReq() to allow subclasses to define there own null checking (not abstract to allow default)
- abstract getContentType() to allow subclasses to return their contentType
- abstract getEncodedContent() that allows subclass to return the content encoded in their specific format 

And I removed abstract form export() and implemented it using all of the above defined functions.
Hence I reduced the unexpectedness and solved issues related to LSP.